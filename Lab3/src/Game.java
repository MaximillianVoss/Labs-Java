import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Александр on 25.05.2017.
 */
public class Game extends JFrame {
    int field[][] = new int[5][5];
    boolean crosses = true;
    String oTurn = "Ходят O", xTurn = "Ходят X", victoryStr = "Победа";

    public void ClearField() {
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[i].length; j++)
                field[i][j] = 0;
    }

    public void UpdateField(int row, int column, int val) {
        crosses = !crosses;
        field[row][column] = val;
        FillTable();
    }

    public void ShowStatus() {
        if (crosses)
            status.setText(xTurn);
        else
            status.setText(oTurn);
        if (Check()) {
            status.setText(victoryStr);
        }
    }

    public int GetSide(boolean side) {
        if (side) return 1;
        else return 2;
    }

    public String GetSymbol(int val) {
        switch (val) {
            case 0:
                return "";
            case 1:
                return "X";
            case 2:
                return "O";
            default:
                return "";
        }
    }

    public void FillTable() {
        DefaultTableModel model = new DefaultTableModel();
        //(DefaultTableModel) table.getModel();
        for (int i = 0; i < 5; i++)
            model.addColumn(i);
        for (int i = 0; i < 5; i++)
            model.addRow(new Object[]{
                    GetSymbol(field[i][0]),
                    GetSymbol(field[i][1]),
                    GetSymbol(field[i][2]),
                    GetSymbol(field[i][3]),
                    GetSymbol(field[i][4])
            });
        table.setModel(model);
        table.setRowHeight(80);
    }

    private boolean Check() {
        boolean res = false;
        for (int i = 0; i < 5; i++) {
            int counter = 0;
            for (int j = 1; j < 5; j++) {
                if (field[i][j - 1] == field[i][j] && field[i][j] != 0)
                    counter++;
            }
            if (counter == 4) {
                res = true;
                break;
            }
        }

        for (int i = 0; i < 5; i++) {
            int counter = 0;
            for (int j = 1; j < 5; j++) {
                if (field[j - 1][i] == field[j][i] && field[j][i] != 0)
                    counter++;
            }
            if (counter == 4) {
                res = true;
                break;
            }
        }

        int counter = 0;
        for (int j = 1; j < 5; j++) {
            if (field[j - 1][j - 1] == field[j][j] && field[j][j] != 0)
                counter++;
        }
        if (counter == 4) {
            res = true;
        }

        counter = 0;
        for (int i = 0, j = 4; i < 4; j--, i++) {
            if (field[i][j] == field[i + 1][j - 1] && field[i][j] != 0)
                counter++;
        }
        if (counter == 4) {
            res = true;
        }


        return res;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        rootPanel.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        startBtn = new JButton();
        startBtn.setText("Начать заново");
        rootPanel.add(startBtn, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        table = new JTable();
        table.setFont(new Font("Bodoni MT Black", table.getFont().getStyle(), 20));
        rootPanel.add(table, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, new Dimension(150, 150), new Dimension(150, 50), null, 0, false));
        status = new JLabel();
        status.setText("Label");
        rootPanel.add(status, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        turnLabel = new JLabel();
        turnLabel.setText("");
        rootPanel.add(turnLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

    //region Enums
    enum type {
        row, column, mdiag, diag
    }

    enum side {empty, zero, cross}

    //endregion
    private int GetCount(int side, type _type, int index) {
        int counter = 0;
        if (_type == type.row) {
            for (int i = 0; i < 5; i++) {
                if (field[index][i] == side)
                    counter++;
            }
        }
        if (_type == type.column) {
            for (int i = 0; i < 5; i++) {
                if (field[i][index] == side)
                    counter++;
            }
        }
        if (_type == type.mdiag) {
            for (int j = 0; j < 5; j++) {
                if (field[j][j] == side)
                    counter++;
            }
        }
        if (_type == type.diag) {
            for (int i = 0, j = 4; i < 5; j--, i++) {
                if (field[i][j] == side)
                    counter++;
            }
        }
        return counter;
    }

    private int[] GetEmptyCell(type _type, int index) {
        if (_type == type.row) {
            for (int i = 0; i < 5; i++) {
                if (field[index][i] == 0)
                    return new int[]{index, i};
            }
        }
        if (_type == type.column) {
            for (int i = 0; i < 5; i++) {
                if (field[i][index] == 0)
                    return new int[]{i, index};
            }
        }
        if (_type == type.mdiag) {
            for (int j = 0; j < 5; j++) {
                if (field[j][j] == 0)
                    return new int[]{j, j};
            }
        }
        if (_type == type.diag) {
            for (int i = 0, j = 4; i < 5; j--, i++) {
                if (field[i][j] == 0)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    private int[] GetAnyEmpty() {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (field[i][j] == 0)
                    return new int[]{i, j};
        return new int[]{-1, -1};
    }

    private String meth = "";

    //0 epmty , 1 cross,2 zero
    private int[] ComputerTurn(side _side) {

        int[] coords = new int[]{-1, -1};
        int max = 0, maxRow = 0, maxColumn = 0, rowIndex = 0, columnIndex = 0, conterSide = 0;
        if (_side == side.cross)
            conterSide = 0;
        else
            conterSide = 1;

        int count = 0;
        int emptyPlace[];
        for (int i = 0; i < 5; i++) {
            //region rows
            count = GetCount(conterSide, type.row, i);
            emptyPlace = GetEmptyCell(type.row, i);
            if (count > max && emptyPlace[0] != -1 & emptyPlace[1] != -1) {
                coords = emptyPlace;
                max = count;
                meth = "rows";
            }
            //endregion
            //region columns
            count = GetCount(conterSide, type.column, i);
            emptyPlace = GetEmptyCell(type.column, i);
            if (count > max && emptyPlace[0] != -1 & emptyPlace[1] != -1) {
                coords = emptyPlace;
                max = count;
                meth = "column";
            }
            //endregion
            //region second diag
            count = GetCount(conterSide, type.diag, i);
            emptyPlace = GetEmptyCell(type.diag, i);
            if (count > max && emptyPlace[0] != -1 & emptyPlace[1] != -1) {
                coords = emptyPlace;
                max = count;
                meth = "diag";
            }
            //endregion
            //region main diag
            count = GetCount(conterSide, type.mdiag, i);
            emptyPlace = GetEmptyCell(type.mdiag, i);
            if (count > max && emptyPlace[0] != -1 & emptyPlace[1] != -1) {
                coords = emptyPlace;
                max = count;
                meth = "main diag";
            }
            //endregion
        }
        return coords;
    }

    private void SetCell(int row, int column) {
        if (table.getValueAt(row, column) == "")
            UpdateField(row, column, GetSide(crosses));
        ShowStatus();
    }

    //region Fields
    private JPanel rootPanel;
    private JButton startBtn;
    private JTable table;
    private JLabel status;
    private JLabel turnLabel;

    //endregion
    public Game() {
        //region Set form
        setContentPane(rootPanel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        //endregion
        //region Fill table
        ClearField();
        FillTable();
        ShowStatus();
        //endregion
        //region Events
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crosses = true;
                ClearField();
                FillTable();
                ShowStatus();
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                SetCell(table.getSelectedRow(), table.getSelectedColumn());
                int[] coords = ComputerTurn(side.zero);
                if (coords[0] == -1 || coords[1] == -1) {
                    turnLabel.setText("Игра окончена");
                } else {
                    SetCell(coords[0], coords[1]);
                    //turnLabel.setText(coords[0] + "," + coords[1] + " " + meth);
                }
            }
        });
    }

    //endregion


    //region GUI
    public static void main(String[] args) {
        new Game();
    }

    //endregion
}