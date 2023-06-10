package component.ComponentsForPanelOrder;

import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import customTable.TableCustom;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.Object.KhoHang;
import model.Object.KhoHangChiTiet;
import model.DAO.KhoHangChiTietDAO;
import model.DAO.KhoHangDAO;
import model.Object.LoaiHang;
import model.DAO.LoaiHangDAO;
import model.Object.SanPham;
import model.DAO.SanPhamDAO;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumnModel;
import model.Object.SanPhamDatHang;

public class PopupImportProductSelection extends javax.swing.JFrame {

    private int index = -1;
    private int originalOrderedNumber = 0;

    private TabPanelImport pnlImport;
    private DefaultTableModel modelTblProduct;

    private Connection connection;
    private SanPhamDAO sanPhamDAO;
    private KhoHangDAO khoDAO;
    private KhoHangChiTietDAO khctDAO;
    private LoaiHangDAO loaiHangDAO;

    private KhoHang kho;

    public PopupImportProductSelection(TabPanelImport pnlImport) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        TableColumnModel columnModelTblOrder = tblProduct.getColumnModel();

        columnModelTblOrder.getColumn(0).setPreferredWidth(20);
        columnModelTblOrder.getColumn(1).setPreferredWidth(180);
        columnModelTblOrder.getColumn(2).setPreferredWidth(60);
        columnModelTblOrder.getColumn(3).setPreferredWidth(50);
        columnModelTblOrder.getColumn(4).setPreferredWidth(50);
        columnModelTblOrder.getColumn(5).setPreferredWidth(100);
        columnModelTblOrder.getColumn(6).setPreferredWidth(120);

        modelTblProduct = (DefaultTableModel) tblProduct.getModel();

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.setBlueColumn(tblProduct, 6);
        this.pnlImport = pnlImport;

        getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        lblProductMenu = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblImporting = new javax.swing.JLabel();
        lbllWarehouse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProduct.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ", "TÊN", "LOẠI", "ĐVT", "GIÁ", "TỒN KHO HIỆN TẠI", "SỐ LƯỢNG ĐẶT HÀNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduct.setToolTipText("");
        tblProduct.getTableHeader().setReorderingAllowed(false);
        tblProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblProductMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduct);
        if (tblProduct.getColumnModel().getColumnCount() > 0) {
            tblProduct.getColumnModel().getColumn(6).setResizable(false);
        }

        lblProductMenu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductMenu.setText("DANH SÁCH SẢN PHẨM ");

        btnConfirm.setBackground(new java.awt.Color(0, 153, 0));
        btnConfirm.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirm.setText("XÁC NHẬN");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(204, 0, 0));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/exit.png"))); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblImporting.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblImporting.setText("CỬA SỔ NHẬP HÀNG CHO");

        lbllWarehouse.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbllWarehouse.setForeground(new java.awt.Color(0, 102, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProductMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImporting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbllWarehouse))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProductMenu)
                            .addComponent(lblImporting)
                            .addComponent(lbllWarehouse))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConfirm)
                        .addGap(143, 143, 143)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        returnOrderedProducts();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void tblProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductMousePressed
        index = tblProduct.getSelectedRow();
        originalOrderedNumber = retriveSoLuongDatHang(index);
    }//GEN-LAST:event_tblProductMousePressed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightFlatIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
        }
    }
    ////////////////////////////////////////////////////////////////////////////

    public void errorMessage(String str) {
        JOptionPane.showMessageDialog(null, str, "LỖI", JOptionPane.ERROR_MESSAGE);
    }

    public boolean customConfirmDialog(String str) {
        int i = JOptionPane.showConfirmDialog(null, str, "Xác nhận",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        return i == JOptionPane.YES_OPTION;
    }
    ////////////////////////////////////////////////////////////////////////////

    public void getConnection() {
        this.connection = pnlImport.getPnlConnection();

        sanPhamDAO = new SanPhamDAO(this.connection);
        khoDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);
        loaiHangDAO = new LoaiHangDAO(this.connection);

        loadDataToTblProduct();
        tblProductEventHandling();
    }

    public void loadDataToTblProduct() {
        try {
            int maKho = this.pnlImport.getCurrentWarehouseID();
            kho = khoDAO.findById(maKho);

            List<SanPhamDatHang> spdhList = this.pnlImport.getSanPhamDatHangHienTai();

            LoaiHang loaiHang;

            for (SanPham sp : sanPhamDAO.findAll()) {
                loaiHang = loaiHangDAO.findById(sp.getMaLh());
                KhoHangChiTiet khct = khctDAO.findOneByMaKhoAndMaSp(maKho, sp.getMaSp());

                int maSp = sp.getMaSp();
                String tenSp = sp.getTenSp();
                String loai = loaiHang.getTenLoai();
                String dvt = loaiHang.getDvt();

                int tonKho = 0;

                try {
                    tonKho = khct.getSoLuong();
                } catch (NullPointerException e) {
                }

                int gia = sp.getGia();
                int soLuongDatHang = 0;

                for (SanPhamDatHang spdh : spdhList) {
                    if (maSp == spdh.getMaSp()) {
                        soLuongDatHang = spdh.getSoLuong();
                    }
                }

                modelTblProduct.addRow(new Object[]{maSp, tenSp, loai, dvt, gia, tonKho, soLuongDatHang});

                if (soLuongDatHang > 0) {
                    TableCustom.setCellColor(tblProduct, (tblProduct.getRowCount() - 1), 6, new Color(204, 102, 0));
                }

                lbllWarehouse.setText(kho.getTenKho().toUpperCase());
            }

        } catch (SQLException ex) {
            Logger.getLogger(PopupImportProductSelection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    public int retriveSoLuongDatHang(int row) {
        int soLuong = 0;
        String soLuongString;

        try {
            soLuong = (int) modelTblProduct.getValueAt(row, 6);
        } catch (NumberFormatException | ClassCastException e) {
            if (modelTblProduct.getValueAt(row, 6) instanceof String) {
                soLuongString = (String) modelTblProduct.getValueAt(row, 6);
                if (soLuongString.matches("^[0-9]+$")) {
                    if (soLuongString.isBlank()) {
                        soLuongString = "0";
                    }

                    soLuong = Integer.parseInt(soLuongString);
                }
            }
        }

        return soLuong;
    }

    public List<Integer> getOrderProductRows() {
        List<Integer> orderedRow = new ArrayList<>();
        for (int i = 0; i < modelTblProduct.getRowCount(); i++) {
            int soLuong = retriveSoLuongDatHang(i);

            if (soLuong > 0) {
                orderedRow.add(i);
            }
        }
        return orderedRow;
    }

    public void returnOrderedProducts() {
        List<SanPhamDatHang> spdhList = new ArrayList<>();

        List<Integer> orderedRow = getOrderProductRows();

        if (!orderedRow.isEmpty()) {
            for (Integer row : orderedRow) {
                int maSp = (int) modelTblProduct.getValueAt(row, 0);
                String tenSp = (String) modelTblProduct.getValueAt(row, 1);
                int soLuong = retriveSoLuongDatHang(row);

                spdhList.add(new SanPhamDatHang(maSp, tenSp, soLuong));
            }
            this.pnlImport.addDetailProduct(spdhList);
            this.dispose();

        } else {
            boolean confirm = customConfirmDialog("Bạn dường như vẫn chưa chọn sản phẩm nào cả!\n "
                    + "Nếu xác nhận sẽ trả về thông tin đơn hàng cũ");
            if (confirm) {
                this.dispose();
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////

    public void tblProductEventHandling() {
        CellEditorListener cellEditorListener = new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                int row = tblProduct.getSelectedRow();
                int column = tblProduct.getSelectedColumn();

                if (column == 6) {
                    Object newValue = tblProduct.getValueAt(row, column);
                    int oldSoLuongDatHang = originalOrderedNumber;
                    int newSoLuongDatHang = retriveSoLuongDatHang(row);

                    if (oldSoLuongDatHang != newSoLuongDatHang) {
                        TableCustom.setCellColor(tblProduct, row, 6, new Color(0, 153, 0));
                    }

                    if (newSoLuongDatHang == 0 && oldSoLuongDatHang != 0) {
                        TableCustom.setCellColor(tblProduct, row, 6, new Color(0, 0, 0));
                    }
                }
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }
        };

        tblProduct.getDefaultEditor(Object.class).addCellEditorListener(cellEditorListener);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImporting;
    private javax.swing.JLabel lblProductMenu;
    private javax.swing.JLabel lbllWarehouse;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}
