/**
 * 
 * 
 * Author: Daniel Forwood
 */


public class Reader {
	
	private String[] fileSize = new String[4];
	private String[] width = new String[4];
	private String[] height = new String[4];
	private String[] horizontalRes = new String[4];
	private String[] verticalRes = new String[4];
	private String[] importantColor = new String[4];
	private String[] rawImageHex;
	private int[] rgb;
	
	

	//Default constructor
	public Reader() {
		
	}
	
	// Parsing the bytes and making sense of which bytes mean what
	public Reader(String[] bmpRawHexArray){

		for(int j = 2; j<6;j++) {
			fileSize[j-2]=bmpRawHexArray[j];
		}
		// Width of the image (in pixels)
		for(int i = 18; i<22;i++) {
			width[i-18]=bmpRawHexArray[i];
		}
		// Height of the image (in pixels)
		for(int i = 22; i<26;i++) {
			height[i-22]=bmpRawHexArray[i];
		}
		
		for(int i = 38; i < 42;i++) {
			horizontalRes[i-38]=bmpRawHexArray[i];
		}
		
		for(int i = 42; i < 46;i++) {
			verticalRes[i-42]=bmpRawHexArray[i];
		}

		for(int i = 50; i< 54; i++) {
			importantColor[i-50]=bmpRawHexArray[i];
		}
		
		//image data that will be used for processing
		int size = bmpRawHexArray.length - 54;
		rawImageHex = new String[size];
		for(int i =54; i < bmpRawHexArray.length; i++) {
			rawImageHex[i-54]=bmpRawHexArray[i];
		}
		

	}
	
	// Parses hex values to RGB values. Reversed order
	public void bmpProcessing() {
		
		rgb = new int[rawImageHex.length];
		//Integer outputDecimal = Integer.parseInt(tmp, 16);
		for(int i = 0; i < rawImageHex.length; i++) {
			rgb[i]=Integer.parseInt(rawImageHex[i],16);
		}
		


	}
	

	
	public int getfileSize() {
		return stringToInt(fileSize);
	}
	
	
	public int getWidth() {
		return stringToInt(width);
	}
	
	public int getHeight() {
		return stringToInt(height);
	}
	
	public int getHoriRes() {
		return stringToInt(horizontalRes);
	}
	
	public int getVertiRes() {
		return stringToInt(verticalRes);
	}
	
	public int getImportantColor() {
		return stringToInt(importantColor);
	}
	
	public String[] getbmpData() {
		return rawImageHex;
	}
	
	//Gets an array of rgb values
	public int[] getrgb() {
		return rgb;
	}
	
	public int stringToInt(String[] blockSizetmp) {
		
		String tmp = "";
		for(int i =0; i < blockSizetmp.length;i++) {
			tmp= blockSizetmp[i] +tmp;
		}
		Integer outputDecimal = Integer.parseInt(tmp, 16);
		return outputDecimal;
	}
}
