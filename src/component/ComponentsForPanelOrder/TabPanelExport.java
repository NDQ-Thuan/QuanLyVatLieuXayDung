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
import model.Object.HoaDon;
import model.Object.HoaDonChiTiet;
import model.DAO.HoaDonChiTietDAO;
import model.DAO.HoaDonDAO;
import model.Object.KhachHang;
import model.DAO.KhachHangDAO;
import model.Object.KhoHang;
import model.DAO.KhoHangDAO;
import model.Object.SanPham;
import model.DAO.SanPhamDAO;
import model.Object.SanPhamDatHang;

public class TabPanelExport extends javax.swing.JPanel {

    private int index = -1;
    private List<SanPhamDatHang> sanPhamDatHangList = new ArrayList<>();

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
        lblTenKhach = new javax.swing.JLabel();
        btnOldCustomer = new javax.swing.JButton();
        lblSDT = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        lblCustomerID = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblCustomerPhone = new javax.swing.JLabel();
        lblCustomerAddress = new javax.swing.JLabel();
        btnNewCustomer = new javax.swing.JButton();
        btnEditCustomerInfo = new javax.swing.JButton();
        cboExportWarehouse = new javax.swing.JComboBox<>();
        btnFilter = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnExportProduct = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        pnlExport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        tblExportDetail.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
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
        tblExportDetail.setFocusable(false);
        tblExportDetail.setRowSelectionAllowed(false);
        tblExportDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExportDetail.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblExportDetail);

        lblExportOrderDetail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblExportOrderDetail.setText("ĐƠN HÀNG CHI TIẾT");

        lblExportOrderID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblExportOrderID.setText("MÃ HÓA ĐƠN");

        tblExportOrder.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        tblExportOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ HĐ", "KHO XUẤT HÀNG", "TÊN KHÁCH", "NGÀY LẬP", "LOẠI ĐƠN", "TRẠNG THÁI"
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
        txtExportID.setFocusable(false);

        lblImportWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblImportWarehouse.setText("KHO LẤY HÀNG");

        btnClear.setBackground(new java.awt.Color(0, 0, 0));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("CLEAR");
        btnClear.setFocusable(false);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lbExportDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbExportDate.setText("NGÀY LẬP ĐƠN");

        btnEdit.setBackground(new java.awt.Color(0, 51, 153));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(242, 242, 242));
        btnEdit.setText("SAVE");
        btnEdit.setFocusable(false);

        txtExportDate.setEditable(false);
        txtExportDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtExportDate.setFocusable(false);

        btnAdd.setBackground(new java.awt.Color(0, 153, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setText("ADD");
        btnAdd.setFocusable(false);

        lblTrangThai.setText("Trạng thái đơn hàng:");

        pnlThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KHÁCH HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10))); // NOI18N

        lblTenKhach.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblTenKhach.setText("TÊN KHÁCH");

        btnOldCustomer.setBackground(new java.awt.Color(0, 102, 102));
        btnOldCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOldCustomer.setForeground(new java.awt.Color(242, 242, 242));
        btnOldCustomer.setText("KHÁCH HÀNG CŨ");
        btnOldCustomer.setFocusable(false);
        btnOldCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOldCustomerActionPerformed(evt);
            }
        });

        lblSDT.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblSDT.setText("SỐ ĐIỆN THOẠI");

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblDiaChi.setText("ĐỊA CHỈ");

        lblCustomerID.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 0, 1)); // NOI18N
        lblCustomerID.setForeground(new java.awt.Color(255, 255, 255));

        lblCustomerName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblCustomerPhone.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        lblCustomerAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N

        btnNewCustomer.setBackground(new java.awt.Color(102, 255, 255));
        btnNewCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNewCustomer.setForeground(new java.awt.Color(51, 51, 51));
        btnNewCustomer.setText("KHÁCH HÀNG MỚI");
        btnNewCustomer.setFocusable(false);
        btnNewCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewCustomerActionPerformed(evt);
            }
        });

        btnEditCustomerInfo.setBackground(new java.awt.Color(0, 51, 51));
        btnEditCustomerInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditCustomerInfo.setForeground(new java.awt.Color(242, 242, 242));
        btnEditCustomerInfo.setText("SỬA THÔNG TIN");
        btnEditCustomerInfo.setFocusable(false);
        btnEditCustomerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditCustomerInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlThongTinKhachHangLayout = new javax.swing.GroupLayout(pnlThongTinKhachHang);
        pnlThongTinKhachHang.setLayout(pnlThongTinKhachHangLayout);
        pnlThongTinKhachHangLayout.setHorizontalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblCustomerPhone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(lblCustomerAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlThongTinKhachHangLayout.createSequentialGroup()
                        .addComponent(lblCustomerID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(137, 137, 137))
                    .addComponent(btnNewCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOldCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditCustomerInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlThongTinKhachHangLayout.setVerticalGroup(
            pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlThongTinKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTenKhach)
                    .addComponent(btnOldCustomer)
                    .addComponent(lblCustomerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNewCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCustomerPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(lblCustomerID)
                .addGap(0, 0, 0)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditCustomerInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCustomerAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );

        cboExportWarehouse.setFocusable(false);
        cboExportWarehouse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboExportWarehouseItemStateChanged(evt);
            }
        });

        btnFilter.setBackground(new java.awt.Color(255, 255, 0));
        btnFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(0, 0, 0));
        btnFilter.setText("FILTER");
        btnFilter.setFocusable(false);

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setText("Đang tạo");

        btnExportProduct.setBackground(new java.awt.Color(102, 0, 102));
        btnExportProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExportProduct.setForeground(new java.awt.Color(242, 242, 242));
        btnExportProduct.setText("MENU SẢN PHẨM");
        btnExportProduct.setFocusable(false);
        btnExportProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportProductActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 0, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("DELETE");
        btnDelete.setFocusable(false);

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
                                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExportLayout.createSequentialGroup()
                                        .addComponent(lblExportOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(pnlExportLayout.createSequentialGroup()
                                        .addComponent(lblImportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboExportWarehouse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtExportID, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlExportLayout.createSequentialGroup()
                                        .addComponent(lbExportDate)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtExportDate, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                                    .addComponent(btnExportProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlExportLayout.createSequentialGroup()
                                .addComponent(lblExportOrderDetail)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExportLayout.createSequentialGroup()
                                .addComponent(lblTrangThai)
                                .addGap(18, 18, 18)
                                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExportLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblImportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboExportWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnExportProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(pnlExportLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlExportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStatus))))
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
            .addGap(0, 942, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnlExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnlExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblExportOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExportOrderMousePressed
        index = tblExportOrder.getSelectedRow();
        int maHd = (int) modelTblOrder.getValueAt(index, 0);
        writeForm(maHd);
    }//GEN-LAST:event_tblExportOrderMousePressed

    private void btnExportProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportProductActionPerformed
        PopupProductSelection popUpProductMenu = new PopupProductSelection(this);
        popUpProductMenu.setVisible(true);
    }//GEN-LAST:event_btnExportProductActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void cboExportWarehouseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboExportWarehouseItemStateChanged
        modelTblDetail.setRowCount(0);

        if (cboExportWarehouse.getSelectedItem().equals("CHỜ BỔ SUNG")) {
            btnExportProduct.setEnabled(false);
        } else {
            btnExportProduct.setEnabled(true);
        }
    }//GEN-LAST:event_cboExportWarehouseItemStateChanged

    private void btnEditCustomerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditCustomerInfoActionPerformed
        String id = lblCustomerID.getText();
        String ten = lblCustomerName.getText();
        String sdt = lblCustomerPhone.getText();
        String diaChi = lblCustomerAddress.getText();

        if (id.isBlank() || ten.isBlank() || sdt.isBlank() || diaChi.isBlank()) {
            errorMessage("Không có thông tin khách hàng để chỉnh sửa!!!");
        } else {
            PopupEditCustomerInfo popupEditCustomerInfo = new PopupEditCustomerInfo(this);
            popupEditCustomerInfo.setVisible(true);
        }

    }//GEN-LAST:event_btnEditCustomerInfoActionPerformed

    private void btnNewCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewCustomerActionPerformed
        PopupNewCustomer popupNewCustomer = new PopupNewCustomer(this);
        popupNewCustomer.setVisible(true);
    }//GEN-LAST:event_btnNewCustomerActionPerformed

    private void btnOldCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOldCustomerActionPerformed
        PopupOldCustomer popupOldCustomer = new PopupOldCustomer(this);
        popupOldCustomer.setVisible(true);
    }//GEN-LAST:event_btnOldCustomerActionPerformed
    ////////////////////////////////////////////////////////////////////////////

    public void errorMessage(String str) {
        JOptionPane.showMessageDialog(null, str, "LỖI", JOptionPane.ERROR_MESSAGE);
    }

    public int customConfirmDialog(String str) {
        return JOptionPane.showConfirmDialog(null, str, "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }

    ////////////////////////////////////////////////////////////////////////////
    public void getConnection(Connection connection) {
        this.connection = connection;

        hoaDonDAO = new HoaDonDAO(this.connection);
        hoaDonChiTietDAO = new HoaDonChiTietDAO(this.connection);
        khachHangDAO = new KhachHangDAO(this.connection);
        sanPhamDAO = new SanPhamDAO(this.connection);
        khoHangDAO = new KhoHangDAO(this.connection);

        tblDetailEvent();
        loadDataToTblOrder();
    }

    public void resetPanel() {
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

            cboExportWarehouse.removeAllItems();
            for (KhoHang kh : khoHangList) {
                cboExportWarehouse.addItem(kh.getTenKho());
            }
            cboExportWarehouse.addItem("CHỜ BỔ SUNG");
            cboExportWarehouse.setSelectedItem("CHỜ BỔ SUNG");

            btnExportProduct.setEnabled(false);

            txtExportDate.setText(hoaDonDAO.formatSQLDateToEuropeDate(getTodayDate()));
        } catch (SQLException ex) {
        }
    }

    public void tblDetailEvent() {
        modelTblDetail.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                sanPhamDatHangList.clear();

                if (tblExportDetail.getRowCount() != 0) {
                    int numberOfSp = tblExportDetail.getRowCount();

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

            txtExportID.setText(hoaDon.getMaHd() + "");
            cboExportWarehouse.setSelectedItem(kho.getTenKho());
            txtExportDate.setText(hoaDon.getNgayLapHoaDon());
            lblStatus.setText(hoaDon.getTrangThai());

            lblCustomerName.setText(khach.getTenKhach());
            lblCustomerPhone.setText(khach.getSdt());
            lblCustomerAddress.setText(khach.getDiaChi());

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

    public void clearForm() {
        txtExportID.setText("TỰ ĐỘNG TẠO MÃ SỐ");

        txtExportDate.setText(hoaDonDAO.formatSQLDateToEuropeDate(getTodayDate()));
        cboExportWarehouse.setSelectedItem("CHỜ BỔ SUNG");

        lblCustomerName.setText("");
        lblCustomerAddress.setText("");
        lblCustomerPhone.setText("");

        lblStatus.setText("Đang tạo");
        modelTblDetail.setRowCount(0);
        tblExportOrder.clearSelection();
    }

//    public List<T> readForm() {
//
//    }
    ////////////////////////////////////////////////////////////////////////////
    public int getCurrentWarehouseID() {
        int maKho = 0;

        try {
            maKho = khoHangDAO.findIdByName((String) cboExportWarehouse.getSelectedItem());
        } catch (SQLException ex) {
            Logger.getLogger(PanelOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maKho;
    }

    public void addCustomerInfo(KhachHang khach) {
        lblCustomerID.setText(khach.getMaKhach() + "");
        lblCustomerName.setText(khach.getTenKhach());
        lblCustomerPhone.setText(khach.getSdt());
        lblCustomerAddress.setText(khach.getDiaChi());
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

    public String getTodayDate() {
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        return date.toString();
    }

    public KhachHang getCurrentKhachHang() {
        try {
            return khachHangDAO.findById(Integer.parseInt(lblCustomerID.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(TabPanelExport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////
    public void handlePopupClosing() {
        setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnClear;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnEditCustomerInfo;
    public javax.swing.JButton btnExportProduct;
    public javax.swing.JButton btnFilter;
    public javax.swing.JButton btnNewCustomer;
    public javax.swing.JButton btnOldCustomer;
    public javax.swing.JComboBox<String> cboExportWarehouse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbExportDate;
    private javax.swing.JLabel lblCustomerAddress;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblCustomerPhone;
    public javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblExportOrderDetail;
    private javax.swing.JLabel lblExportOrderID;
    private javax.swing.JLabel lblImportWarehouse;
    public javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblStatus;
    public javax.swing.JLabel lblTenKhach;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JPanel pnlExport;
    private javax.swing.JPanel pnlThongTinKhachHang;
    public javax.swing.JTable tblExportDetail;
    public javax.swing.JTable tblExportOrder;
    public javax.swing.JTextField txtExportDate;
    public javax.swing.JTextField txtExportID;
    // End of variables declaration//GEN-END:variables
}
