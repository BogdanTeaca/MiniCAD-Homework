package utils;
import java.awt.Color;

/**
 * @author TEACA BOGDAN
 */
public abstract class ColorUtils {
    private static final int RADIX = 16;
    private static final int NR_COLOR_COMPONENTS = 3;

    /**
     * Metoda statica ce converteste culoarea din format "#RGB A" intr-un intreg ce poate
     * fi folosit de metodele setRGB() si getRGB() ale clasei BufferImage.
     */
    public static int convertHexToRgb(final String color, final int alpha) {
        int[] colorRGB = new int[NR_COLOR_COMPONENTS];

        for (int i = 1; i <= NR_COLOR_COMPONENTS; i++) {
            colorRGB[i - 1] = Integer.valueOf(color.substring(2 * i - 1, 2 * i + 1), RADIX);
        }

        return new Color(colorRGB[0], colorRGB[1], colorRGB[2], alpha).getRGB();
    }
}
