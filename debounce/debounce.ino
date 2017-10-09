const int buttonPin = 2;
int count = 0;

unsigned long lastDebounceTime = 0;
unsigned long debounceDelay = 30;

void buttonPressed() {
  Serial.println("Interrupt");
  lastDebounceTime = millis();
  count += 1;
  if((millis() - lastDebounceTime) > debounceDelay){
      count = count + 1;
  }
}

void setup() {
  pinMode(buttonPin, INPUT_PULLUP);

  attachInterrupt(digitalPinToInterrupt(buttonPin), buttonPressed, CHANGE);
  Serial.begin(9600);
}

void loop() {
   Serial.println("1 sec has passed!");
   delay(1000);
}
