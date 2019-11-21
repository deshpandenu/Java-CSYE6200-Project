package edu.neu.csye6200;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fazecast.jSerialComm.*;

public class Ports {
	
	private int portStatus = 0;
	private String portNameC="blank";
	private SerialPort port;
	//private SerialPort portsAvailable[];
	private SerialPort AvailablePorts[] = SerialPort.getCommPorts();
	
	public Ports() {
		super();
		// TODO Auto-generated constructor stub
	
	}

	public List<String> getMenuPorts()
	{
		List<String> portNames = new ArrayList<String>();
		if(AvailablePorts.length>0)
		for (SerialPort port : AvailablePorts)
			portNames.add(port.getSystemPortName());
		return portNames;
	
	}
	
	public int connectPort(String portName)
	{
		if(portNameC.compareTo(portName)!=0)
		{
			for (SerialPort portL : AvailablePorts)
			{
				if(portL.getSystemPortName()==portName)
				port=portL;
				port.setComPortParameters(9600, 8, 1, 0);
				port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,0, 0);	
				
				if(port.openPort())
				{
					System.out.println("Port open");
					try 
					{
						System.out.println("Sleeping");
						Thread.sleep(1000);
						System.out.println("Awake");
						portStatus = 1;
					} 
					catch (InterruptedException e1)
					{
						// TODO Auto-generated catch block						
						e1.printStackTrace();
						return 0;
					}
						if(portStatus==1)
						{
							byte[] op = "1".getBytes();
							try {
									System.out.println("opening light");
									port.getOutputStream().write(op);
									try {
											Thread.sleep(3000);
										} 
									catch (InterruptedException e) 
										{
										// TODO Auto-generated catch block
										e.printStackTrace();
										}
								} 
							
							catch (IOException e) 
								{
								
								// TODO Auto-generated catch block
								e.printStackTrace();
								return 0;
								}
						}
				}
				
				else
				{
					System.out.println("not open");
								System.out.println("Terminating");
				}
			}
				
		}
		return 1;
	}//Method ending
	
	
	
}
