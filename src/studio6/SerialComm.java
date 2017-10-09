package studio6;

import jssc.*;

public class SerialComm {

	SerialPort port;

	private boolean debug;  // Indicator of "debugging mode"
	
	
	// This function can be called to enable or disable "debugging mode"
	void setDebug(boolean mode) {
		debug = mode;
	}	
	

	// Constructor for the SerialComm class
	public SerialComm(String name) throws SerialPortException {
		port = new SerialPort(name);		
		port.openPort();
		port.setParams(SerialPort.BAUDRATE_9600,
			SerialPort.DATABITS_8,
			SerialPort.STOPBITS_1,
			SerialPort.PARITY_NONE);
		
		debug = false; // Default is to NOT be in debug mode
	}
		
	void readByte(int val) throws SerialPortException{
		
		if(debug){		
			String hex = String.format("%02x", readByte());
			System.out.println(hex);
		}else{
			String hex = String.format("%02x", readByte());
			System.out.println(hex);			
		}
		
		
	}
	
    // TODO: Add available() method
	boolean available() throws SerialPortException{
		return port.getInputBufferBytesCount() >= 1;
	}
	
	// TODO: Add readByte() method	
	byte[] readByte() throws SerialPortException{
		byte[] val = port.readBytes(1);
		if(debug){		
			String hex = String.format("%02x", val[0]);
			System.out.println(hex);
		}
		return val;
		
	}
	
	// TODO: Add a main() method
	public static void main(String[] args) throws SerialPortException{
		SerialComm comm = new SerialComm("COM3");
		while(true){
			if(comm.available()){
				char val = (char)comm.readByte()[0];
				System.out.print(val);
				
			}
		}
	}
	
}
