package component;

import customTable.TableCustom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.HoaDonChiTietDAO;
import model.HoaDonDAO;
import model.KhachHang;
import model.KhachHangDAO;
import model.KhoHang;
import model.KhoHangDAO;
import model.SanPham;
import model.SanPhamDAO;

public class TabPanelExport extends javax.swing.JPanel {

    private int index = -1;

    private DefaultTableModel modelTblOrder;
    private DefaultTableModel modelTblDetail;

    private Connection connection;
    private HoaDonDAO hoaDonDAO;
    private HoaDonChiTietDAO hoaDonChiTietDAO;
    private KhachHangDAO khachHangDAO;
    private SanPhamDAO sanPhamDAO;
    private KhoHangDAO khoHangDAO;

    public TabPanelExport() {
        initComponents();

        modelTblOrder = (DefaultTableModel) tblExportOrder.getModel();
        modelTblDetail = (DefaultTableModel) tblExportDetail.getModel();

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlExport = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblExportDetail = new javax.swing.JTable();
        lblExportOrderDetail = new javax.swing.JLabel();
        lblExportOrderID = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExportOrder = new javax.swing.JTable();
        txtExportID = new javax.swing.JTextField();
        lblImportWarehouse = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        lbExportDate = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        txtExportDate = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblTrangThai = new javax.swing.JLabel();
        pnlThongTinKhachHang = new javax.swing.JPanel();
        lblCustomerName = new javax.swing.JLabel();
        btnOldCustomer = new javax.swing.JButton();
        txtCustomerName = new javax.swing.JTextField();
        lblCustomerPhone = new javax.swing.JLabel();
        txtCustomerPhone = new javax.swing.JTextField();
        lblCustomerAddress = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        btnClearCustomerInfo = new javax.swing.JButton();
        lblCustomerID = new javax.swing.JLabel();
        cboImportWarehouse = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnExportProduct = new javax.swing.JButton();
        btnExportProductEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        pnlExport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        tblExportDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        tblExportDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExportDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblExportDetail);

        lblExportOrderDetail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblExportOrderDetail.setText("ĐƠN HÀNG CHI TIẾT");

        lblExportOrderID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblExportOrderID.setText("MÃ HÓA ĐƠN");

        tblExportOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ HĐ", "KHO HÀNG", "TÊN KHÁCH", "NGÀY LẬP", "LOẠI ĐƠN", "TRẠNG THÁI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblExportOrder.setFocusable(false);
        tblExportOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExportOrder.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExportOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblExportOrderMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblExportOrder);

        txtExportID.setEditable(false);
        txtExportID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtExportID.setText("TỰ ĐỘNG TẠO MÃ SỐ");

        lblImportWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblImportWarehouse.setText("KHO LẤY HÀNG");

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");

        lbExportDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbExportDate.setText("NGÀY LẬP ĐƠN");

        btnEdit.setBackground(new java.awt.Color(0, 51, 153));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(242, 242, 242));
        btnEdit.setText("SAVE");

        txtExportDate.setEditable(false);
        txtExportDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnAdd.setBackground(new java.awt.Color(0, 153, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setText("ADD");

        lblTrangThai.setText("Trạng thái đơn hàng:");

        pnlThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KHÁCH HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10))); // NOI18N

        lblCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblCustomerName.setText("TÊN KHÁCH");

        btnOldCustomer.setBackground(new java.awt.Color(0, 102, 102));
        btnOldCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOldCustomer.setForeground(new java.awt.Color(242, 242, 242));
        btnOldCustomer.setText("KHÁCH HÀNG CŨ");
        btnOldCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOldCustomerActionPerformed(evt);
            }
        });

        txtCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lblCustomerPhone.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblCustomerPhone.setText("SỐ ĐIỆN THOẠI");

        txtCustomerPhone.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lblCustomerAddress.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblCustomerAddress.setText("ĐỊA CHỈ");

        txtCustomerAddress.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        btnClearCustomerInfo.setBackground(new java.awt.Color(153, 102, 0));
        btnClearCustomerInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearCustomerInfo.setForeground(new java.awt.Color(242, 242, 242));
        btnClearCustomerInfo.setText("XÓA THÔNG TIN");

        lblCustomerID.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        lblCustomerID.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlThongTinKhachHangLayout = new javax.swing.GroupLayout(pnlThongTinKhachHang);
        pnlThongTinKhachHang.setLayout(pnlThongTinKhachHangLayout);
        pnlThongTinKhachHangLayout.setHorizontalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCustomerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCustomerAddress, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlThongTinKhachHangLayout.createSequentialGroup()
                        .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomerID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClearCustomerInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOldCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlThongTinKhachHangLayout.setVerticalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerName)
                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOldCustomer))
                .addGap(10, 10, 10)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerPhone)
                    .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerID))
                .addGap(10, 10, 10)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerAddress)
                    .addComponent(txtCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearCustomerInfo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cboImportWarehouse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        btnFilter.setBackground(new java.awt.Color(255, 255, 0));
        btnFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(0, 0, 0));
        btnFilter.setText("FILTER");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setText("Đang tạo");

        btnExportProduct.setBackground(new java.awt.Color(153, 0, 153));
        btnExportProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExportProduct.setForeground(new java.awt.Color(242, 242, 242));
        btnExportProduct.setText("CHỌN SẢN PHẨM ");
        btnExportProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportProductActionPerformed(evt);
            }
        });

        btnExportProductEdit.setBackground(new java.awt.Color(51, 255, 255));
        btnExportProductEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExportProductEdit.setForeground(new java.awt.Color(0, 0, 0));
        btnExportProductEdit.setText("EDIT SẢN PHẨM");

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");

        javax.swing.GroupLayout pnlExportLayout = new javax.swing.GroupLayout(pnlExport);
        pnlExport.setLayout(pnlExportLayout);
        pnlExportLayout.setHorizontalGroup(
            pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlThongTinKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlExportLayout.createSequentialGroup()
                                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlExportLayout.createSequentialGroup()
                                        .addComponent(lblExportOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtExportID))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlExportLayout.createSequentialGroup()
                                        .addComponent(lblImportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboImportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30)
                                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlExportLayout.createSequentialGroup()
                                        .addComponent(lbExportDate)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtExportDate))
                                    .addGroup(pnlExportLayout.createSequentialGroup()
                                        .addComponent(btnExportProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnExportProductEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlExportLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblExportOrderDetail)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExportLayout.createSequentialGroup()
                                        .addComponent(lblTrangThai)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExportLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addGap(6, 6, 6))
        );
        pnlExportLayout.setVerticalGroup(
            pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlExportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExportID)
                    .addComponent(lblExportOrderDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExportOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbExportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtExportDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus)))
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblImportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboImportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnExportProductEdit))
                            .addComponent(btnExportProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblExportOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExportOrderMousePressed

    }//GEN-LAST:event_tblExportOrderMousePressed

    private void btnOldCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOldCustomerActionPerformed

    }//GEN-LAST:event_btnOldCustomerActionPerformed

    private void btnExportProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportProductActionPerformed

    }//GEN-LAST:event_btnExportProductActionPerformed

    public void getConnection(Connection connection) {
        this.connection = connection;

        hoaDonDAO = new HoaDonDAO(this.connection);
        hoaDonChiTietDAO = new HoaDonChiTietDAO(this.connection);
        khachHangDAO = new KhachHangDAO(this.connection);
        sanPhamDAO = new SanPhamDAO(this.connection);
        khoHangDAO = new KhoHangDAO(this.connection);

        loadDataToTblOrder();
    }

    public void disableButtonOnUserRole(String role) {
    }

    public Connection getPnlConnection() {
        return this.connection;
    }

    public void loadDataToTblOrder() {
        try {
            modelTblOrder.setRowCount(0);

            List<HoaDon> hoaDonList = hoaDonDAO.findExportOrder();

            for (HoaDon hd : hoaDonList) {
                KhoHang kho = khoHangDAO.findById(hd.getMaKho());
                int id = hd.getMaHd();
                String tenKho = kho.getTenKho();
                String tenKhach = khachHangDAO.getTenKhachByID(hd.getMaKhach());
                String ngayLap = hd.getNgayLapHoaDon();
                String loaiHD = hd.getLoaiHoaDon();
                String trangThai = hd.getTrangThai();

                modelTblOrder.addRow(new Object[]{id, tenKho, tenKhach, ngayLap, loaiHD, trangThai});
            }

            List<KhoHang> khoHangList = khoHangDAO.findAll();

            for (KhoHang kh : khoHangList) {
                cboImportWarehouse.addItem(kh.getTenKho());
            }
        } catch (SQLException ex) {
        }
    }

    public void writeForm(int maHD) {
        try {
            HoaDon hoaDon = hoaDonDAO.findById(maHD);
            KhoHang kho = khoHangDAO.findById(hoaDon.getMaKho());
            KhachHang khach = khachHangDAO.findById(hoaDon.getMaKhach());

            txtExportID.setText(hoaDon.getMaHd() + "");
            cboImportWarehouse.setSelectedItem(kho.getTenKho());
            txtExportDate.setText(hoaDon.getNgayLapHoaDon());
            lblStatus.setText(hoaDon.getTrangThai());

            txtCustomerName.setText(khach.getTenKhach());
            txtCustomerPhone.setText(khach.getSdt());
            txtCustomerAddress.setText(khach.getDiaChi());

            modelTblDetail.setRowCount(0);
            List<HoaDonChiTiet> hdctList = hoaDonChiTietDAO.findByMaHd(maHD);

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

    public int getCurrentWarehouseID() {
        int maKho = 0;

        try {
            maKho = khoHangDAO.findIdByName((String) cboImportWarehouse.getSelectedItem());
        } catch (SQLException ex) {
            Logger.getLogger(PanelOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maKho;
    }

    public void addCustomerInfo(KhachHang khach) {
        txtCustomerName.setText(khach.getTenKhach());
        txtCustomerPhone.setText(khach.getSdt());
        txtCustomerAddress.setText(khach.getDiaChi());
    }

    public void addDetailProduct(SanPham sp, int soLuong) {
        modelTblDetail.addRow(new Object[]{sp.getMaSp(), sp.getTenSp(), soLuong});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnClear;
    public javax.swing.JButton btnClearCustomerInfo;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnExportProduct;
    private javax.swing.JButton btnExportProductEdit;
    public javax.swing.JButton btnFilter;
    public javax.swing.JButton btnOldCustomer;
    public javax.swing.JComboBox<String> cboImportWarehouse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbExportDate;
    public javax.swing.JLabel lblCustomerAddress;
    private javax.swing.JLabel lblCustomerID;
    public javax.swing.JLabel lblCustomerName;
    public javax.swing.JLabel lblCustomerPhone;
    private javax.swing.JLabel lblExportOrderDetail;
    private javax.swing.JLabel lblExportOrderID;
    private javax.swing.JLabel lblImportWarehouse;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlExport;
    private javax.swing.JPanel pnlThongTinKhachHang;
    public javax.swing.JTable tblExportDetail;
    public javax.swing.JTable tblExportOrder;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerPhone;
    public javax.swing.JTextField txtExportDate;
    public javax.swing.JTextField txtExportID;
    // End of variables declaration//GEN-END:variables
}
