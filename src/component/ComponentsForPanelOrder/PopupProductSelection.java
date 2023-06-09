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
import model.Object.SanPhamDatHang;

public class PopupProductSelection extends javax.swing.JFrame {

    private int index = -1;
    private int originalOrderedNumber = 0;

    private TabPanelExport pnlExport;
    private DefaultTableModel modelTblProduct;

    private Connection connection;
    private SanPhamDAO sanPhamDAO;
    private KhoHangDAO khoDAO;
    private KhoHangChiTietDAO khctDAO;
    private LoaiHangDAO loaiHangDAO;

    private KhoHang kho;

    public PopupProductSelection(TabPanelExport pnlExport) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        modelTblProduct = (DefaultTableModel) tblProduct.getModel();

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.setBlueColumn(tblProduct, 6);
        this.pnlExport = pnlExport;

        getConnection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        lblProductMenu = new javax.swing.JLabel();
        lblWarehouseName = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProduct.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ", "TÊN", "LOẠI", "ĐVT", "GIÁ", "TỒN KHO", "SỐ LƯỢNG ĐẶT HÀNG"
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
        lblProductMenu.setText("DANH SÁCH SẢN PHẨM THUỘC");

        lblWarehouseName.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lblWarehouseName.setForeground(new java.awt.Color(0, 0, 153));

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
        btnCancel.setText("X");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProductMenu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWarehouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 239, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
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
                            .addComponent(lblWarehouseName))
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
        this.connection = pnlExport.getPnlConnection();

        sanPhamDAO = new SanPhamDAO(this.connection);
        khoDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);
        loaiHangDAO = new LoaiHangDAO(this.connection);

        loadDataToTblProduct();
        tblProductEventHandling();
    }

    public void loadDataToTblProduct() {
        try {
            int maKho = this.pnlExport.getCurrentWarehouseID();
            kho = khoDAO.findById(maKho);

            List<KhoHangChiTiet> khctList = khctDAO.findByMaKhoWithoutFlaggedProduct(maKho);
            List<SanPhamDatHang> spdhList = this.pnlExport.getSanPhamDatHangHienTai();

            SanPham sp;
            LoaiHang loaiHang;

            for (KhoHangChiTiet khct : khctList) {
                sp = sanPhamDAO.findById(khct.getMaSp());
                loaiHang = loaiHangDAO.findById(sp.getMaLh());

                int maSp = sp.getMaSp();
                String tenSp = sp.getTenSp();
                String loai = loaiHang.getTenLoai();
                String dvt = loaiHang.getDvt();
                int gia = sp.getGia();
                int soLuong = khct.getSoLuong();
                int soLuongDatHang = 0;

                for (SanPhamDatHang spdh : spdhList) {
                    if (maSp == spdh.getMaSp()) {
                        soLuongDatHang = spdh.getSoLuong();
                    }
                }

                modelTblProduct.addRow(new Object[]{maSp, tenSp, loai, dvt, gia, soLuong, soLuongDatHang});

                if (soLuongDatHang > 0) {
                    TableCustom.setCellColor(tblProduct, (tblProduct.getRowCount() - 1), 6, new Color(204, 102, 0));
                }
            }

            lblWarehouseName.setText(kho.getTenKho().toUpperCase());
        } catch (SQLException ex) {
            Logger.getLogger(PopupProductSelection.class.getName()).log(Level.SEVERE, null, ex);
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

    public boolean orderProductValidation(int row) {
        try {
            int maSp = (int) modelTblProduct.getValueAt(row, 0);
            String tenSp = (String) modelTblProduct.getValueAt(row, 1);
            int soLuongDatHang = retriveSoLuongDatHang(row);

            KhoHangChiTiet khct = khctDAO.findOneByMaKhoAndMaSp(kho.getMaKho(), maSp);
            int soLuongTonKho = khct.getSoLuong();

            if (soLuongDatHang > soLuongTonKho) {
                errorMessage("Sản phẩm đặt hàng " + tenSp + " có số lượng đặt LỚN HƠN số lượng tồn kho!");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PopupProductSelection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public boolean validateInfo() {
        boolean flag = true;

        List<Integer> orderedRows = getOrderProductRows();

        for (Integer row : orderedRows) {
            if (!orderProductValidation(row)) {
                flag = false;
            }
        }

        return flag;
    }

    public void returnOrderedProducts() {
        List<SanPhamDatHang> spdhList = new ArrayList<>();

        if (validateInfo()) {
            List<Integer> orderedRow = getOrderProductRows();

            if (!orderedRow.isEmpty()) {
                for (Integer row : orderedRow) {
                    int maSp = (int) modelTblProduct.getValueAt(row, 0);
                    String tenSp = (String) modelTblProduct.getValueAt(row, 1);
                    int soLuong = retriveSoLuongDatHang(row);

                    spdhList.add(new SanPhamDatHang(maSp, tenSp, soLuong));
                }
                this.pnlExport.addDetailProduct(spdhList);
                this.dispose();

            } else {
                boolean confirm = customConfirmDialog("Bạn dường như vẫn chưa chọn sản phẩm nào cả!\n "
                        + "Nếu xác nhận sẽ trả về thông tin đơn hàng cũ");
                if (confirm) {
                    this.dispose();
                }
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

                    int soLuongTonKho = (int) tblProduct.getValueAt(row, 5);

                    if (oldSoLuongDatHang != newSoLuongDatHang) {
                        TableCustom.setCellColor(tblProduct, row, 6, new Color(0, 153, 0));
                    }

                    if (newSoLuongDatHang == 0) {
                        TableCustom.setCellColor(tblProduct, row, 6, new Color(0, 0, 0));
                    }

                    int n = oldSoLuongDatHang - newSoLuongDatHang;
                    soLuongTonKho += n;

                    tblProduct.setValueAt(soLuongTonKho, row, 5);
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
    private javax.swing.JLabel lblProductMenu;
    private javax.swing.JLabel lblWarehouseName;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}
