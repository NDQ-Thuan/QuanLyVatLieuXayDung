package customTable;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CellColorRenderer extends DefaultTableCellRenderer {

    private final DefaultTableCellRenderer defaultRenderer;
    private final int rowIndex;
    private final int columnIndex;
    private final Color color;

    public CellColorRenderer(DefaultTableCellRenderer defaultRenderer, int rowIndex, int columnIndex, Color color) {
        this.defaultRenderer = defaultRenderer;
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.color = color;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (row == rowIndex && column == columnIndex) {
            com.setBackground(color);
        }
        return com;
    }
}
