package com.kiwii.chinese.services.input;

import java.awt.image.BufferedImage;
import java.io.File;


public interface ORCReader {

	public String read(BufferedImage source);
	public String read(File source);
}
