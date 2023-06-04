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

public final class PanelOrder extends ConnectionPanel {

    private int index = -1;

    private DefaultTableModel modelTblOrder;
    private DefaultTableModel modelTblDetail;

    private Connection connection;
    private HoaDonDAO hoaDonDAO;
    private HoaDonChiTietDAO hoaDonChiTietDAO;
    private KhachHangDAO khachHangDAO;
    private SanPhamDAO sanPhamDAO;
    private KhoHangDAO khoHangDAO;

    public PanelOrder() {
        initComponents();

        modelTblOrder = (DefaultTableModel) tblOrder.getModel();
        modelTblDetail = (DefaultTableModel) tblDetail.getModel();

        TableCustom.apply(jScrollPane1, TableCustom.TableType.DEFAULT);
        TableCustom.apply(jScrollPane2, TableCustom.TableType.DEFAULT);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOrderID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblWarehouse = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        lblType = new javax.swing.JLabel();
        cboType = new javax.swing.JComboBox<>();
        cboWarehouse = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        lblOrderDetail = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnlThongTinKhachHang = new javax.swing.JPanel();
        lblCustomerName = new javax.swing.JLabel();
        btnOldCustomer = new javax.swing.JButton();
        btnOldCustomer1 = new javax.swing.JButton();
        txtCustomerName = new javax.swing.JTextField();
        lblCustomerPhone = new javax.swing.JLabel();
        txtCustomerPhone = new javax.swing.JTextField();
        lblCustomerAddress = new javax.swing.JLabel();
        txtCustomerAddress = new javax.swing.JTextField();
        btnOldCustomer2 = new javax.swing.JButton();
        lblTrangThai = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnAdd1 = new javax.swing.JButton();

        lblOrderID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrderID.setText("MÃ HÓA ĐƠN");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblWarehouse.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblWarehouse.setText("KHO LẤY HÀNG");

        lblDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDate.setText("NGÀY LẬP ĐƠN");

        txtDate.setEditable(false);
        txtDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        lblType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblType.setText("LOẠI HÓA ĐƠN");

        cboType.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xuất", "Nhập" }));

        cboWarehouse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

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
        jScrollPane2.setViewportView(tblDetail);

        lblOrderDetail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrderDetail.setText("ĐƠN HÀNG CHI TIẾT");

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOrder.setFocusable(false);
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblOrderMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        btnClear.setBackground(new java.awt.Color(242, 242, 242));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setText("CLEAR");

        btnEdit.setBackground(new java.awt.Color(0, 51, 153));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(242, 242, 242));
        btnEdit.setText("SAVE");

        btnDelete.setBackground(new java.awt.Color(204, 51, 0));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(242, 242, 242));
        btnDelete.setText("DELETE");

        btnAdd.setBackground(new java.awt.Color(0, 153, 51));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd.setText("ADD");

        jButton2.setBackground(new java.awt.Color(153, 0, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(242, 242, 242));
        jButton2.setText("MENU SẢN PHẨM");

        pnlThongTinKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "KHÁCH HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 10))); // NOI18N

        lblCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblCustomerName.setText("TÊN KHÁCH");

        btnOldCustomer.setBackground(new java.awt.Color(0, 102, 102));
        btnOldCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOldCustomer.setForeground(new java.awt.Color(242, 242, 242));
        btnOldCustomer.setText("KHÁCH HÀNG CŨ");

        btnOldCustomer1.setBackground(new java.awt.Color(0, 51, 204));
        btnOldCustomer1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOldCustomer1.setForeground(new java.awt.Color(242, 242, 242));
        btnOldCustomer1.setText("SỬA THÔNG TIN");

        txtCustomerName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lblCustomerPhone.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblCustomerPhone.setText("SỐ ĐIỆN THOẠI");

        txtCustomerPhone.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lblCustomerAddress.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblCustomerAddress.setText("ĐỊA CHỈ");

        txtCustomerAddress.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        btnOldCustomer2.setBackground(new java.awt.Color(153, 102, 0));
        btnOldCustomer2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOldCustomer2.setForeground(new java.awt.Color(242, 242, 242));
        btnOldCustomer2.setText("XÓA THÔNG TIN");

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
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCustomerAddress)
                    .addComponent(txtCustomerName)
                    .addComponent(txtCustomerPhone))
                .addGap(18, 18, 18)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOldCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOldCustomer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOldCustomer2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerPhone)
                    .addComponent(txtCustomerPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOldCustomer1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlThongTinKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCustomerAddress)
                    .addComponent(txtCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOldCustomer2))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        lblTrangThai.setText("Trạng thái đơn hàng:");

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblStatus.setText("Đang tạo");

        btnAdd1.setBackground(new java.awt.Color(0, 153, 51));
        btnAdd1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd1.setForeground(new java.awt.Color(242, 242, 242));
        btnAdd1.setText("FILTER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(btnAdd1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlThongTinKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtID)
                                    .addComponent(cboWarehouse, 0, 184, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblType)
                                    .addComponent(lblDate))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboType, 0, 176, Short.MAX_VALUE)
                                    .addComponent(txtDate))))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTrangThai)
                                .addGap(18, 18, 18)
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOrderDetail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID)
                    .addComponent(lblOrderDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblStatus)
                            .addComponent(lblTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(pnlThongTinKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addGap(35, 35, 35)
                        .addComponent(btnAdd1)
                        .addGap(35, 35, 35)
                        .addComponent(btnAdd)
                        .addGap(35, 35, 35)
                        .addComponent(btnEdit)
                        .addGap(35, 35, 35)
                        .addComponent(btnDelete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMousePressed
        index = tblOrder.getSelectedRow();
        int maHD = (int) modelTblOrder.getValueAt(index, 0);

        writeForm(maHD);
    }//GEN-LAST:event_tblOrderMousePressed

    public void getConnection(Connection connection) {
        this.connection = connection;

        hoaDonDAO = new HoaDonDAO(this.connection);
        hoaDonChiTietDAO = new HoaDonChiTietDAO(this.connection);
        khachHangDAO = new KhachHangDAO(this.connection);
        sanPhamDAO = new SanPhamDAO(this.connection);
        khoHangDAO = new KhoHangDAO(this.connection);

        loadDataToTblOrder();
    }

    public void loadDataToTblOrder() {
        try {
            modelTblOrder.setRowCount(0);

            List<HoaDon> hoaDonList = hoaDonDAO.findAll();

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
                cboWarehouse.addItem(kh.getTenKho());
            }
        } catch (SQLException ex) {
        }
    }

    public void writeForm(int maHD) {
        try {
            HoaDon hoaDon = hoaDonDAO.findById(maHD);
            KhoHang kho = khoHangDAO.findById(hoaDon.getMaKho());
            KhachHang khach = khachHangDAO.findById(hoaDon.getMaKhach());

            txtID.setText(hoaDon.getMaHd() + "");
            cboType.setSelectedItem(hoaDon.getLoaiHoaDon());
            cboWarehouse.setSelectedItem(kho.getTenKho());
            txtDate.setText(hoaDon.getNgayLapHoaDon());
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnAdd1;
    public javax.swing.JButton btnClear;
    public javax.swing.JButton btnDelete;
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnOldCustomer;
    public javax.swing.JButton btnOldCustomer1;
    public javax.swing.JButton btnOldCustomer2;
    public javax.swing.JComboBox<String> cboType;
    public javax.swing.JComboBox<String> cboWarehouse;
    public javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel lblCustomerAddress;
    public javax.swing.JLabel lblCustomerName;
    public javax.swing.JLabel lblCustomerPhone;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblOrderDetail;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblWarehouse;
    private javax.swing.JPanel pnlThongTinKhachHang;
    public javax.swing.JTable tblDetail;
    public javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtCustomerAddress;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtCustomerPhone;
    public javax.swing.JTextField txtDate;
    public javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
