package q3_SaulMarinho;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class rgb {

    public static void main(String[] args) {
 
        BufferedImage inputImage = loadInputImage("C:\\temp\\ws-java\\q3_SaulMarinho\\src\\pastor_entrada.jpg");
        Scanner sc = new Scanner(System.in);

        // Define o fator de ajuste de brilho (entre -255 e 255)
        System.out.print("Digite um valor entre -255 e 255: ");
        int brightnessFactor = sc.nextInt(); 

        BufferedImage outputImage = adjustBrightness(inputImage, brightnessFactor);

        saveOutputImage(outputImage, "C:\\temp\\ws-java\\q3_SaulMarinho\\src\\pastor_resultado.jpg");

        System.out.println("Ajuste de brilho aplicado com sucesso!");
        sc.close();
    }

    private static BufferedImage loadInputImage(String filePath) {
        try {
            return ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static BufferedImage adjustBrightness(BufferedImage inputImage, int brightnessFactor) {
        int width = inputImage.getWidth();
        int height = inputImage.getHeight();

        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color pixelColor = new Color(inputImage.getRGB(x, y));

                int red = clamp(pixelColor.getRed() + brightnessFactor, 0, 255);
                int green = clamp(pixelColor.getGreen() + brightnessFactor, 0, 255);
                int blue = clamp(pixelColor.getBlue() + brightnessFactor, 0, 255);

                Color newColor = new Color(red, green, blue);
                outputImage.setRGB(x, y, newColor.getRGB());
            }
        }

        return outputImage;
    }

    private static void saveOutputImage(BufferedImage outputImage, String filePath) {
        try {
            ImageIO.write(outputImage, "jpg", new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
}