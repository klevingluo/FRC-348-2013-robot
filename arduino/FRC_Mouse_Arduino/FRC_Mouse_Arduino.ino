// Wire Slave Sender
// by Nicholas Zambetti <http://www.zambetti.com>

// Demonstrates use of the Wire library
// Sends data as an I2C/TWI slave device
// Refer to the "Wire Master Reader" example for use with this

// Created 29 March 2006

// This example code is in the public domain.


#include <Wire.h>
#include <ps2.h>

PS2 mouse(6, 5);

int x = 0;
int y = 0;

double theta = 0.0;

void mouse_init()
{
  mouse.write(0xff);  // reset
  mouse.read();  // ack byte
  mouse.read();  // blank */
  mouse.read();  // blank */
  mouse.write(0xEA);  // remote mode
  mouse.write(0xF4);
  mouse.read();  // ack
  delayMicroseconds(100);
}

void setup()
{
  Serial.begin(9600);
  mouse_init();
  Wire.begin(2);                // join i2c bus with address #2
  Wire.onRequest(requestEvent); // register event
}

void loop() {
  char mstat;
  char mx;
  char my;

  /* get a reading from the mouse */
  mouse.write(0xeb);    // give me data!
  mouse.read();         // ignore ack
  mstat = mouse.read(); //
  mx = mouse.read();
  my = mouse.read();
  
  x += (int) mx;
  y += (int)my;
  
  theta = (atan2(x,y)/(2*PI));  // mouse data
  Serial.println(theta);
  
  /*if(x > 10) {
    digitalWrite(left, HIGH);
    digitalWrite(right, LOW);
  } else if (x < -10) {
    digitalWrite(right, HIGH);
    digitalWrite(left, LOW);
  } else {
    digitalWrite(right, LOW);
    digitalWrite(left, LOW);
  }*/
/*
  Serial.print("\tX=");
  Serial.print(x);
  Serial.print("\tY=");
  Serial.print(y);
  Serial.print("\tTheta=");
  Serial.print(theta);
  Serial.println();
  delay(100);*/
}

// function that executes whenever data is requested by master
// this function is registered as an event, see setup()
void requestEvent()
{
  int t = theta * 1000000000;
  String s = String(t);
  for(int i = 0; i < s.length(); i++) {
    Wire.write(s.charAt(i)); // respond with message of 4 bytes
  }
}
