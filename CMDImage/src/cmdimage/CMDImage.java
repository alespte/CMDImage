package cmdimage;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
/**
 *
 * @author ales
 */
public class CMDImage {
    
    public static void createBWImage(String inputImagePath, String outputImagePath) throws IOException{ 
        File file = new File(inputImagePath);
        BufferedImage orginalImage = ImageIO.read(file);
        BufferedImage blackAndWhiteImg = new BufferedImage(orginalImage.getWidth(), orginalImage.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D graphics = blackAndWhiteImg.createGraphics();
        graphics.drawImage(orginalImage, 0, 0, null);
        ImageIO.write(blackAndWhiteImg, "png", new File(outputImagePath));
    }
    
    public static void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }

    public static void resizing(String inputImagePath, String outputImagePath) {
        try {
            int scaledWidth = 80;
            int scaledHeight = 80;
            CMDImage.resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
    }
    
    public static void printMangaImage(String Location) {
        String Salida;
        try {
            InputStream input = new FileInputStream(Location);
            ImageInputStream imageInput = ImageIO.createImageInputStream(input);
            BufferedImage ImagenL = ImageIO.read(imageInput);

            int alto = ImagenL.getHeight();
            int ancho = ImagenL.getWidth();

            System.out.println("Alto: " + alto + "Ancho: " + ancho);
            for (int y = 0; y < alto; y++) {
                for (int x = 0; x < ancho; x++) {
                    int srcPixel = ImagenL.getRGB(x, y);
                    Color c = new Color(srcPixel);

                    int valR = c.getRed();
                    int valG = c.getGreen();
                    int valB = c.getBlue();

                    if (valR >= 160 && valG >= 160 && valB >= 160) {
                        if (valR >= 215 && valG >= 215 && valB >= 215) {
                            Salida = "##";
                        } else {
                            Salida = "//";
                        }
                    } else {
                        Salida = "  ";
                    }
                    System.out.print(Salida);
                }
                System.out.println("");
            }
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        String imagePath = "C:\\Users\\aldex\\OneDrive\\Documents\\NetBeansProjects\\CMDImage\\nagatoro.jpg";
        String generatedBWImagePath = "C:\\Users\\aldex\\OneDrive\\Documents\\NetBeansProjects\\CMDImage\\nagatoroBW.jpg ";
        String resizedBWImagePath = "C:\\Users\\aldex\\OneDrive\\Documents\\NetBeansProjects\\CMDImage\\nagatororesized.jpg";
        
        createBWImage(imagePath, generatedBWImagePath);
        resizing(generatedBWImagePath, resizedBWImagePath);
        printMangaImage(resizedBWImagePath);
        
    }

}
