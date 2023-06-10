package component.ComponentsForPanelOrder;

import component.PanelForMainMenu.PanelOrder;
import customTable.TableCustom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.Object.HoaDon;
import model.Object.HoaDonChiTiet;
import model.DAO.HoaDonChiTietDAO;
import model.DAO.HoaDonDAO;
import model.Object.KhachHang;
import model.DAO.KhachHangDAO;
import model.DAO.KhoHangChiTietDAO;
import model.Object.KhoHang;
import model.DAO.KhoHangDAO;
import model.Object.SanPham;
import model.DAO.SanPhamDAO;
import model.Object.KhoHangChiTiet;
import model.Object.SanPhamDatHang;
import util.DateUtils;

public class TabPanelImport extends javax.swing.JPanel {

    private String userRole = "QL";

    private int index = -1;
    private List<SanPhamDatHang> sanPhamDatHangList = new ArrayList<>();

    public PanelOrder pnlOrder;

    private DefaultTableModel modelTblOrder;
    private DefaultTableModel modelTblDetail;

    private Connection connection;
    private HoaDonDAO hoaDonDAO;
    private HoaDonChiTietDAO hdctDAO;
    private KhachHangDAO khachHangDAO;
    private SanPhamDAO sanPhamDAO;
    private KhoHangDAO khoHangDAO;
    private KhoHangChiTietDAO khctDAO;

    public TabPanelImport() {
        initComponents();

        modelTblOrder = (DefaultTableModel) tblImportOrder.getModel();
        modelTblDetail = (DefaultTableModel) tblDetail.getModel();

        TableColumnModel columnModelTblOrder = tblImportOrder.getColumnModel();

        columnModelTblOrder.getColumn(0).setPreferredWidth(20);
        columnModelTblOrder.getColumn(1).setPreferredWidth(180);
        columnModelTblOrder.getColumn(2).setPreferredWidth(50);
        columnModelTblOrder.getColumn(3).setPreferredWidth(50);
        columnModelTblOrder.getColumn(4).setPreferredWidth(50);

        TableColumnModel columnModelTblOrderDetail = tblDetail.getColumnModel();

        columnModelTblOrderDetail.getColumn(0).setPreferredWidth(10);
        columnModelTblOrderDetail.getColumn(1).setPreferredWidth(120);
        columnModelTblOrderDetail.getColumn(2).setPreferredWidth(20);

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlImport = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        lblImportOrderDetail = new javax.swing.JLabel();
        lblImportOrderID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblImportOrder = new javax.swing.JTable();
        txtImportID = new javax.swing.JTextField();
        lblImportWarehouse = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        lblImportDate = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtImportDate = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblTrangThai = new javax.swing.JLabel();
        pnlThongTinKhoHang = new javax.swing.JPanel();
        lblTenKho = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblWarehouseID = new javax.swing.JLabel();
        lblWarehouseName = new javax.swing.JLabel();
        lblWarehousePhone = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblWarehouseAddress = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnImportProduct = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnWarehouse = new javax.swing.JButton();
        btnSuccess = new javax.swing.JButton();

        pnlImport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        tblDetail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ SP", "TÊN SP ", "SỐ LƯỢNG"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetail.setFocusable(false);
        tblDetail.setRowSelectionAllowed(false);
        tblDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblDetail);

        lblImportOrderDetail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblImportOrderDetail.setText("ĐƠN HÀNG CHI TIẾT");

        lblImportOrderID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblImportOrderID.setText("MÃ HÓA ĐƠN");

        tblImportOrder.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblImportOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MÃ HĐ", "KHO NHẬP HÀNG", "NGÀY LẬP", "LOẠI ĐƠN", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImportOrder.setFocusable(false);
        tblImportOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblImportOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblImportOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblImportOrderMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblImportOrder);

        txtImportID.setEditable(false);
        txtImportID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtImportID.setText("TỰ ĐỘNG TẠO MÃ SỐ");
        txtImportID.setFocusable(false);

        lblImportWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblImportWarehouse.setText("KHO NHẬP HÀNG");

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/clear.png"))); // NOI18N
        btnClear.setFocusable(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblImportDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblImportDate.setText("NGÀY LẬP ĐƠN");

        btnSave.setBackground(new java.awt.Color(0, 51, 153));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(242, 242, 242));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/save.png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.setFocusable(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtImportDate.setEditable(false);
        txtImportDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtImportDate.setFocusable(false);

        btnAdd.setBackground(new java.awt.Color(0, 153, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/add.png"))); // NOI18N
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblTrangThai.setText("Trạng thái đơn hàng:");

        pnlThongTinKhoHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KHO HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10))); // NOI18N

        lblTenKho.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblTenKho.setText("TÊN KHO");

        lblSDT.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblSDT.setText("SỐ ĐIỆN THOẠI");

        lblWarehouseID.setBackground(new java.awt.Color(255, 255, 255));
        lblWarehouseID.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        lblWarehouseID.setForeground(new java.awt.Color(255, 255, 255));

        lblWarehouseName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblWarehousePhone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblDiaChi.setText("ĐỊA CHỈ");

        lblWarehouseAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlThongTinKhoHangLayout = new javax.swing.GroupLayout(pnlThongTinKhoHang);
        pnlThongTinKhoHang.setLayout(pnlThongTinKhoHangLayout);
        pnlThongTinKhoHangLayout.setHorizontalGroup(
            pnlThongTinKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhoHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinKhoHangLayout.createSequentialGroup()
                        .addGap(354, 354, 354)
                        .addComponent(lblWarehouseID, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                        .addGap(75, 75, 75))
                    .addGroup(pnlThongTinKhoHangLayout.createSequentialGroup()
                        .addGroup(pnlThongTinKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWarehouseName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblWarehousePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblWarehouseAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnlThongTinKhoHangLayout.setVerticalGroup(
            pnlThongTinKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinKhoHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenKho, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWarehouseName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlThongTinKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWarehousePhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(pnlThongTinKhoHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWarehouseAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(lblWarehouseID))
        );

        btnFilter.setBackground(new java.awt.Color(204, 102, 0));
        btnFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(0, 0, 0));
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/filter.png"))); // NOI18N
        btnFilter.setFocusable(false);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setText("Đang tạo");

        btnImportProduct.setBackground(new java.awt.Color(102, 0, 102));
        btnImportProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnImportProduct.setForeground(new java.awt.Color(242, 242, 242));
        btnImportProduct.setText("MENU SẢN PHẨM");
        btnImportProduct.setFocusable(false);
        btnImportProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportProductActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ButtonIcon/delete.png"))); // NOI18N
        btnDelete.setEnabled(false);
        btnDelete.setFocusable(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnWarehouse.setBackground(new java.awt.Color(0, 102, 102));
        btnWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnWarehouse.setForeground(new java.awt.Color(242, 242, 242));
        btnWarehouse.setText("CHỌN KHO");
        btnWarehouse.setFocusable(false);
        btnWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWarehouseActionPerformed(evt);
            }
        });

        btnSuccess.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuccess.setText("SUCCESSIFY");
        btnSuccess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuccessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlImportLayout = new javax.swing.GroupLayout(pnlImport);
        pnlImport.setLayout(pnlImportLayout);
        pnlImportLayout.setHorizontalGroup(
            pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlImportLayout.createSequentialGroup()
                        .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlImportLayout.createSequentialGroup()
                                .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblImportOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblImportWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtImportID, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(btnWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlImportLayout.createSequentialGroup()
                                        .addComponent(lblImportDate)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtImportDate))
                                    .addComponent(btnImportProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pnlThongTinKhoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlImportLayout.createSequentialGroup()
                                .addComponent(lblTrangThai)
                                .addGap(18, 18, 18)
                                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                            .addGroup(pnlImportLayout.createSequentialGroup()
                                .addComponent(lblImportOrderDetail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSuccess))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(pnlImportLayout.createSequentialGroup()
                        .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addGap(6, 6, 6))
        );
        pnlImportLayout.setVerticalGroup(
            pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImportID)
                    .addComponent(lblImportOrderDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImportOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImportDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuccess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlImportLayout.createSequentialGroup()
                        .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblImportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnWarehouse))
                            .addComponent(btnImportProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlThongTinKhoHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlImportLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus))))
                .addGap(17, 17, 17)
                .addGroup(pnlImportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlImportLayout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addGap(20, 20, 20)
                        .addComponent(btnAdd)
                        .addGap(20, 20, 20)
                        .addComponent(btnSave)
                        .addGap(20, 20, 20)
                        .addComponent(btnFilter)
                        .addGap(20, 20, 20)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlImport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblImportOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImportOrderMousePressed
        index = tblImportOrder.getSelectedRow();
        int maHd = (int) modelTblOrder.getValueAt(index, 0);
        writeForm(maHd);
        buttonOnUpdate();
    }//GEN-LAST:event_tblImportOrderMousePressed

    private void btnImportProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportProductActionPerformed
        if (lblWarehouseName.getText().isBlank()
                || lblWarehouseID.getText().isBlank()
                || lblWarehousePhone.getText().isBlank() || lblWarehouseAddress.getText().isBlank()) {
            errorMessage("Vui lòng cung cấp thông tin kho nhập hàng trước khi chọn sản phẩm");
        } else {
            PopupImportProductSelection popup = new PopupImportProductSelection(this);
            popup.setVisible(true);
        }
    }//GEN-LAST:event_btnImportProductActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWarehouseActionPerformed
        PopupWarehouse popupWarehouse = new PopupWarehouse(this);
        popupWarehouse.setVisible(true);
    }//GEN-LAST:event_btnWarehouseActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            addHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            updateHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            deleteHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSuccessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuccessActionPerformed
        try {
            successifyHoaDon();
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuccessActionPerformed
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

    public void getConnection(Connection connection, PanelOrder panelOrder) {
        this.connection = connection;
        this.pnlOrder = panelOrder;
        this.userRole = this.pnlOrder.getUserRole();

        if (this.userRole.equals("NV")) {
            btnDelete.setEnabled(false);
        }

        hoaDonDAO = new HoaDonDAO(this.connection);
        hdctDAO = new HoaDonChiTietDAO(this.connection);
        khachHangDAO = new KhachHangDAO(this.connection);
        sanPhamDAO = new SanPhamDAO(this.connection);
        khoHangDAO = new KhoHangDAO(this.connection);
        khctDAO = new KhoHangChiTietDAO(this.connection);

        tblDetailEvent();
        loadDataToTblOrder();
    }

    public void resetPanel() {
        clearForm();

        loadDataToTblOrder();

        if (index != -1) {
            dragTableToIndex(index);
        }
    }

    public void dragTableToIndex(int i) {
        tblImportOrder.requestFocus();
        tblImportOrder.changeSelection(i, 0, false, false);
        tblImportOrder.setRowSelectionInterval(i, i);
        writeForm((int) tblImportOrder.getValueAt(i, 0));
        buttonOnUpdate();
    }

    public Connection getPnlConnection() {
        return this.connection;
    }

    public void loadDataToTblOrder() {
        try {
            modelTblOrder.setRowCount(0);

            List<HoaDon> hoaDonList = hoaDonDAO.findImportOrder();

            for (HoaDon hd : hoaDonList) {
                KhoHang kho = khoHangDAO.findById(hd.getMaKho());
                int id = hd.getMaHd();
                String tenKho = kho.getTenKho();
                String tenKhach = khachHangDAO.getNameByID(hd.getMaKhach());
                String ngayLap = hd.getNgayLapHoaDon();
                String loaiHD = hd.getLoaiHoaDon();
                String trangThai = hd.getTrangThai();

                modelTblOrder.addRow(new Object[]{id, tenKhach, ngayLap, loaiHD, trangThai});
            }

            List<KhoHang> khoHangList = khoHangDAO.findAll();
            txtImportDate.setText(getTodayDate());
        } catch (SQLException ex) {
        }
    }

    public void tblDetailEvent() {
        modelTblDetail.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                sanPhamDatHangList.clear();

                if (tblDetail.getRowCount() != 0) {
                    int numberOfSp = tblDetail.getRowCount();

                    for (int i = 0; i < numberOfSp; i++) {
                        int maSp = (int) modelTblDetail.getValueAt(i, 0);
                        String tenSp = (String) modelTblDetail.getValueAt(i, 1);
                        int soLuong = (int) modelTblDetail.getValueAt(i, 2);

                        sanPhamDatHangList.add(new SanPhamDatHang(maSp, tenSp, soLuong));
                    }
                }
            }
        });
    }

    ////////////////////////////////////////////////////////////////////////////
    public void writeForm(int maHD) {
        try {
            HoaDon hoaDon = hoaDonDAO.findById(maHD);
            KhoHang kho = khoHangDAO.findById(hoaDon.getMaKho());
            KhachHang khach = khachHangDAO.findById(hoaDon.getMaKhach());

            txtImportID.setText(hoaDon.getMaHd() + "");
            txtImportDate.setText(hoaDon.getNgayLapHoaDon());
            lblStatus.setText(hoaDon.getTrangThai());

            lblWarehouseID.setText(khach.getMaKhach() + "");
            lblWarehouseName.setText(khach.getTenKhach());
            lblWarehousePhone.setText(khach.getSdt());
            lblWarehouseAddress.setText(khach.getDiaChi());

            modelTblDetail.setRowCount(0);
            List<HoaDonChiTiet> hdctList = hdctDAO.findByOrderID(maHD);

            for (HoaDonChiTiet hdct : hdctList) {
                SanPham sp = sanPhamDAO.findById(hdct.getMaSp());

                int maSP = sp.getMaSp();
                String tenSP = sp.getTenSp();
                int soLuong = hdct.getSoLuong();

                modelTblDetail.addRow(new Object[]{maSP, tenSP, soLuong});
            }

        } catch (SQLException ex) {
            Logger.getLogger(PanelOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearForm() {
        txtImportID.setText("TỰ ĐỘNG TẠO MÃ SỐ");

        txtImportDate.setText(getTodayDate());

        lblWarehouseName.setText("");
        lblWarehouseAddress.setText("");
        lblWarehousePhone.setText("");

        lblStatus.setText("Đang tạo");
        modelTblDetail.setRowCount(0);
        tblImportOrder.clearSelection();

        buttonOnAdd();
    }

    public HoaDon returnHoaDon() throws SQLException {
        int maHd = 0;

        try {
            maHd = Integer.parseInt(txtImportID.getText());
        } catch (NumberFormatException e) {
        }

        String ngayLapDon = DateUtils.convertToSQLDate(txtImportDate.getText());

        int maKhach = Integer.parseInt(lblWarehouseID.getText());

        return new HoaDon(maHd, maKhach, maKhach, ngayLapDon, "Nhập", "Pending");
    }

    public List<HoaDonChiTiet> returnHDCT() {
        int maHd = 0;

        try {
            maHd = Integer.parseInt(txtImportID.getText());
        } catch (NumberFormatException e) {
        }

        List<HoaDonChiTiet> hdctList = new ArrayList<>();

        int hdctRow = tblDetail.getRowCount();

        if (hdctRow != 0) {
            for (int i = 0; i < hdctRow; i++) {
                int maSp = (int) modelTblDetail.getValueAt(i, 0);
                int soLuong = (int) modelTblDetail.getValueAt(i, 2);

                hdctList.add(new HoaDonChiTiet(maSp, maHd, soLuong));
            }
        }

        return hdctList;
    }

    public boolean validateInfo() {
        boolean flag = true;

        if (lblWarehouseName.getText().isBlank()
                || lblWarehouseID.getText().isBlank()
                || lblWarehousePhone.getText().isBlank()) {
            errorMessage("Vui lòng cung cấp thông tin kho nhập hàng");
            return false;
        }

        if (tblDetail.getRowCount() == 0) {
            errorMessage("Vui lòng chọn sản phẩm nhập hàng");
            flag = false;
        }

        return flag;
    }

    public boolean isTwoOrdersTheSame() throws SQLException {
        int maHd = Integer.parseInt(txtImportID.getText());

        HoaDon oldHoaDon = hoaDonDAO.findById(maHd);
        List<HoaDonChiTiet> oldHDCTList = hdctDAO.findByOrderID(oldHoaDon.getMaHd());

        HoaDon newHoaDon = returnHoaDon();
        List<HoaDonChiTiet> newHDCTList = returnHDCT();

        if (!oldHoaDon.equals(newHoaDon)) {
            return false;
        }

        if (!oldHDCTList.equals(newHDCTList)) {
            return false;
        }

        for (int i = 0; i < oldHDCTList.size(); i++) {
            if (!oldHDCTList.get(i).equals(newHDCTList.get(i))) {
                return false;
            }
        }

        return true;
    }

    public void addHoaDon() throws SQLException {
        if (validateInfo()) {
            if (customConfirmDialog("Thêm hóa đơn mới này?")) {
                HoaDon hoaDon = returnHoaDon();
                hoaDonDAO.insert(hoaDon);

                hoaDon = hoaDonDAO.findNewest();
                txtImportID.setText(hoaDon.getMaHd() + "");

                List<HoaDonChiTiet> hdctList = returnHDCT();
                KhoHangChiTiet khct;

                for (HoaDonChiTiet hdct : hdctList) {
                    hdctDAO.insert(hdct);
                }

                index = 0;
                this.pnlOrder.askMainMenuToRestart();
                JOptionPane.showMessageDialog(null, "Thêm hóa đơn mới thành công!");
            }
        }
    }

    public void updateHoaDon() throws SQLException {
        if (!validateInfo()) {
            return;
        }

        int maHd = Integer.parseInt(txtImportID.getText());

        HoaDon oldHoaDon = hoaDonDAO.findById(maHd);

        HoaDon newHoaDon = returnHoaDon();
        List<HoaDonChiTiet> newHDCT = returnHDCT();

        int maKho = oldHoaDon.getMaKho();

        boolean diff = isTwoOrdersTheSame();

        if (oldHoaDon.getTrangThai().equals("Delivering")) {
            errorMessage("Không thể thay đổi thông tin hóa đơn ở trạng thái đang giao");
            clearForm();
            return;
        }

        if (!diff) {
            boolean confirmUpdate = customConfirmDialog("Tiếp tục cập nhật hóa đơn này?");
            if (confirmUpdate) {
                hoaDonDAO.update(newHoaDon);

                hdctDAO.deleteByOrderID(maHd);

                for (HoaDonChiTiet hdct : newHDCT) {
                    hdctDAO.insert(hdct);
                }

                this.pnlOrder.askMainMenuToRestart();
                JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thành công!");
            }
        }
    }

    public void deleteHoaDon() throws SQLException {
        int maHd = Integer.parseInt(txtImportID.getText());

        HoaDon hoaDon = hoaDonDAO.findById(maHd);

        String startDate = hoaDon.getNgayLapHoaDon();
        String today = getTodayDate();

        long daySinceCreated = DateUtils.dateCalculator(startDate, today);

        if (hoaDon.getTrangThai().equals("Delivering")) {
            errorMessage("Không thể xóa hóa đơn ở trạng thái ĐANG GIAO");
            clearForm();
            return;
        }

        if (hoaDon.getTrangThai().equals("Pending")) {
            boolean confirm = customConfirmDialog("Đơn hàng đang chờ được giao\n"
                    + "Tiếp tục xóa đơn hàng này");
            if (confirm) {
                hoaDonDAO.delete(maHd);
                index = -1;
                this.pnlOrder.askMainMenuToRestart();
                JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!");
            }
        } else if (daySinceCreated < 360) {
            boolean confirm = customConfirmDialog("Đơn hàng này được tạo và có thời gian lưu trữ dưới 1 năm\n"
                    + "Bạn có chắc chắn muốn xóa đơn hàng này?");
            if (confirm) {
                hoaDonDAO.delete(maHd);
                index = -1;
                this.pnlOrder.askMainMenuToRestart();
                JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!");
            }
        }
    }

    public void successifyHoaDon() throws SQLException {
        int maHd = (int) tblImportOrder.getValueAt(index, 0);

        if (maHd != 0) {

            HoaDon hoaDon = returnHoaDon();

            System.out.println(hoaDon.getNgayLapHoaDon());

            if (hoaDon.getTrangThai().equals("Pending")
                    || hoaDon.getTrangThai().equals("Delivering")) {
                boolean confirm = customConfirmDialog("Cập nhật tình trạng đơn hàng này thành 'Success'?");

                if (confirm) {
                    hoaDon.setTrangThai("Success");
                    hoaDonDAO.update(hoaDon);
                    List<HoaDonChiTiet> hdctList = hdctDAO.findByOrderID(maHd);

                    KhoHang kho = khoHangDAO.findById(hoaDon.getMaKho());
                    KhoHangChiTiet khct;

                    for (HoaDonChiTiet hdct : hdctList) {
                        khct = khctDAO.findOneByWarehouseAndProductID(kho.getMaKho(), hdct.getMaSp());

                        if (khct != null) {
                            int tonKho = khct.getSoLuong();
                            int nhapHang = hdct.getSoLuong();
                            int tongKho = tonKho + nhapHang;

                            khct.setSoLuong(tongKho);
                            khctDAO.update(khct);
                        } else {
                            khct = new KhoHangChiTiet(kho.getMaKho(), hdct.getMaSp(), hdct.getSoLuong());
                            khctDAO.insert(khct);
                        }
                    }

                    this.pnlOrder.askMainMenuToRestart();
                    JOptionPane.showMessageDialog(null, "Hóa đơn giao hàng thành công!");
                }
            }
        }
    }
////////////////////////////////////////////////////////////////////////////

    public void addWarehouseInfo(KhachHang khach) {
        lblWarehouseID.setText(khach.getMaKhach() + "");
        lblWarehouseName.setText(khach.getTenKhach());
        lblWarehousePhone.setText(khach.getSdt());
        lblWarehouseAddress.setText(khach.getDiaChi());
    }

    public void addDetailProduct(List<SanPhamDatHang> spdhlist) {
        modelTblDetail.setRowCount(0);

        for (SanPhamDatHang spdh : spdhlist) {
            int maSp = spdh.getMaSp();
            String tenSp = spdh.getTenSp();
            int soLuong = spdh.getSoLuong();

            modelTblDetail.addRow(new Object[]{maSp, tenSp, soLuong});
        }
    }

    public List<SanPhamDatHang> getSanPhamDatHangHienTai() {
        return this.sanPhamDatHangList;
    }

    public int getCurrentWarehouseID() {
        return Integer.parseInt(lblWarehouseID.getText());
    }

    public String getTodayDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return DateUtils.convertToEuropeanDate(date.toString());
    }

    ////////////////////////////////////////////////////////////////////////////
    public void buttonOnUpdate() {
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(true);

        if (userRole.equals("NV")) {
            btnDelete.setEnabled(false);
        }
    }

    public void buttonOnAdd() {
        btnAdd.setEnabled(true);
        btnSave.setEnabled(false);
        btnDelete.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnClear;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnFilter;
    public javax.swing.JButton btnImportProduct;
    public javax.swing.JButton btnSave;
    private javax.swing.JButton btnSuccess;
    public javax.swing.JButton btnWarehouse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblImportDate;
    private javax.swing.JLabel lblImportOrderDetail;
    private javax.swing.JLabel lblImportOrderID;
    private javax.swing.JLabel lblImportWarehouse;
    public javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblStatus;
    public javax.swing.JLabel lblTenKho;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblWarehouseAddress;
    private javax.swing.JLabel lblWarehouseID;
    private javax.swing.JLabel lblWarehouseName;
    private javax.swing.JLabel lblWarehousePhone;
    private javax.swing.JPanel pnlImport;
    private javax.swing.JPanel pnlThongTinKhoHang;
    public javax.swing.JTable tblDetail;
    public javax.swing.JTable tblImportOrder;
    public javax.swing.JTextField txtImportDate;
    public javax.swing.JTextField txtImportID;
    // End of variables declaration//GEN-END:variables
}
