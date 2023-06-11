package util;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.Dimension;

public class ImageUtils {

    public static void setImageIcon(JLabel label, ImageIcon imageIcon) {
        Dimension labelSize = label.getSize();

        Image originalImage = imageIcon.getImage();

        Image scaledImage = originalImage.getScaledInstance(labelSize.width, labelSize.height, Image.SCALE_SMOOTH);

        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        label.setIcon(scaledImageIcon);
    }
}
