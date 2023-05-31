CREATE DATABASE QuanLyVatLieuXayDung;
GO


USE QuanLyVatLieuXayDung;
GO

-- USER
CREATE TABLE USERS(
	USERNAME NVARCHAR(50) NOT NULL
	CONSTRAINT PK_USERNAME PRIMARY KEY(USERNAME),
	PASSWORD VARCHAR(20),
	ROLE NVARCHAR(50)
);
GO


--MAIN
CREATE TABLE KHACHHANG (
    MAKHACH INT IDENTITY(1,1) PRIMARY KEY,
    TENKHACH NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(100) NOT NULL,
    SDT VARCHAR(15) NOT NULL
);
GO


CREATE TABLE NHACUNGCAP (
    MANCC INT IDENTITY(1,1) PRIMARY KEY,
    TENNCC NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(100) NOT NULL,
    SDT VARCHAR(15) NOT NULL,
);
GO


CREATE TABLE LOAIHANG (
    MALH INT IDENTITY(1,1) PRIMARY KEY,
    TENLOAI NVARCHAR(50) NOT NULL,
    DVT NVARCHAR(10) NOT NULL,
);
GO


CREATE TABLE SANPHAM (
    MASP INT IDENTITY(1,1) PRIMARY KEY,
    MALH INT NOT NULL,
    MANCC INT NOT NULL,
	TENSP NVARCHAR(50) NOT NULL,
    GIA INT NOT NULL,
    FOREIGN KEY (MALH) REFERENCES LOAIHANG(MALH),
    FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP(MANCC)
);
GO


CREATE TABLE KHOHANG (
    MAKHO INT IDENTITY(1,1) PRIMARY KEY,
    DIACHI NVARCHAR(50) NOT NULL,
	SDTQUANLY VARCHAR(15) NULL,
);
GO


CREATE TABLE KHOHANGCHITIET (
    MAKHO INT NOT NULL,
    MASP INT NOT NULL,
    SOLUONG INT NOT NULL,
    FOREIGN KEY (MASP) REFERENCES SANPHAM(MASP),
	FOREIGN KEY (MAKHO) REFERENCES KHOHANG(MAKHO)
);
GO


CREATE TABLE HOADON (
    MAHD INT IDENTITY(1,1) PRIMARY KEY,
    MAKHACH INT NOT NULL,
	MAKHO INT NOT NULL,
    NGAYLAPHOADON DATE NOT NULL,
    LOAIHOADON NVARCHAR(10) NOT NULL,
    TRANGTHAI NVARCHAR(10) NOT NULL,
    FOREIGN KEY (MAKHACH) REFERENCES KHACHHANG(MAKHACH),
	FOREIGN KEY (MAKHO) REFERENCES KHOHANG(MAKHO)
);
GO


CREATE TABLE HOADONCHITIET (
    MASP INT NOT NULL,
    MAHD INT NOT NULL,
    SOLUONG INT NOT NULL,
    FOREIGN KEY (MASP) REFERENCES SANPHAM (MASP),
    FOREIGN KEY (MAHD) REFERENCES HOADON (MAHD)
);
GO


INSERT INTO KHACHHANG (TENKHACH, DIACHI, SDT)
VALUES
    (N'Công ty Xây Dựng Thiên Hạ', N'123 Đường Pauster, Quận 5, TP. HCM', '0901234567'),
    (N'Công ty Kiến Trúc Xanh', N'456 QL 1A, Quận 12, TP. HCM', '0912345678'),
    (N'Công ty Thiết Kế Phong Cách Mới', N'77 Đường CMT8, Quận Bình Thạnh, TP. HCM', '0923456789'),
    (N'Công ty CP Xây Dựng Hà Tiên', N'33/4 Đường Số 2, Quận Hóc Môn, TP. HCM', '0934567890'),
    (N'Công ty TNHH Thương Mại Green Tech', N'99A Đường Trường Chinh, Quận Hoàn Kiếm, Hà Nội', '0945678901'),
    (N'Công ty CP Thiết Kế Ngoại Thất', N'37 Đường Nguyễn Du, TP. Vũng Tàu', '0956789012'),
    (N'Công ty CP Xây Dựng Ngọc Long', N'222 Đường Lạc Long Quân, Quận XYZ, Đà Nẵng', '0967890123'),
    (N'Công ty TNHH Kiến Trúc Kình Ba', N'654 Đường Lương Thế Vinh, TP. Vinh', '0978901234'),
    (N'Công ty Building Future', N'31 QL62 , TP. Tân An, Long An', '0989012345'),
    (N'Công ty CP VLXD Đào Nguyên', N'9 Đường Số 6, Quận Tân Bình, TP. HCM', '0990123456');
GO

INSERT INTO LOAIHANG (TENLOAI, DVT) VALUES
	(N'Xi Măng', N'Bao'),
	(N'Thép', N'Cây'),
	(N'Cát', N'M3'),
	(N'Gạch', N'Viên'),
	(N'Sắt', N'Cây'),
	(N'Sàn', N'Vỉ'),
	(N'Tường', N'M2'),
	(N'Trần', N'M2'),
	(N'Nội Thất', N'Cái'),
	(N'Ngoại Thất', N'Cái');
GO


INSERT INTO NHACUNGCAP (TENNCC, DIACHI, SDT) VALUES
	(N'Công ty CP SX TM VLXD Sài Gòn',N'99/3 Nguyễn Hữu Dật, P. Tây Thạnh, Q. Tân Phú, TP. HCM','0909789888'),
	(N'Công ty Song Phương - Bảo Hợp Tín',N'283 Tây Thạnh, P. Tây Thạnh, Q. Tân Phú, TP. HCM','0944414797'),
	(N'Công ty Vina Built',N'394/35 Âu Cơ, P. 10, Q. Tân Bình, TP.HCM','0987447766'),
	(N'Công ty CP Hòa Phát, tập đoàn Hòa Phát',N'66 Nguyễn Du, P. Nguyễn Du, Q. Hai Bà Trưng, Hà Nội','02462848666'),
	(N'Công ty CP Tập đoàn Hoa Sen',N'183 Nguyễn Văn Trỗi, Phường 10, Q. Phú Nhuận, TP. HCM','18001515'),
	(N'Công ty CP An Cường',N'Đường ĐT 747B, Khu phố Phước Hải, P. Thái Hòa, Thị xã Tân Uyên, Tỉnh Bình Dương','19006944'),
	(N'Công ty CP Bình Minh',N'240 Hậu Giang, Phường 9, Q.6, TP. HCM','02839690973'),
	(N'Công ty CP Hà Tiên 1',N'604 Võ Văn Kiệt, Cầu Kho, Q.1, TP. HCM','02838368363'),
	(N'Công ty TNHH Thương Mại Green Tech',N'B2 Đường Số 3, Khu Phố 4, Phường An Khánh, Tp. Thủ Đức, TP. HCM','0972699926'),
	(N'Công ty TNHH Nam Tiền Phong',N'44A, Đường Số 8, P. Tam Phú, TP. Thủ Đức, Tp. HCM','0859737888');
GO


INSERT INTO SANPHAM (MALH, MANCC, TENSP, GIA)
VALUES
    (1, 1, N'Xi măng xây dựng chất lượng cao', 200000),
    (2, 2, N'Sắt thép xây dựng chịu lực', 250000),
    (3, 3, N'Cát xây dựng sạch', 120000),
    (4, 4, N'Gạch xây dựng vuông chất lượng tốt', 5000),
    (5, 5, N'Sắt tròn cường độ cao', 80000),
    (6, 6, N'Sàn gỗ công nghiệp chống trầy xước', 350000),
    (7, 7, N'Gạch lát tường cao cấp', 200000),
    (8, 8, N'Vật liệu trần nhựa PVC', 300000),
    (9, 9, N'Bộ ngoại thất phong cách thiên nhiên', 700000),
    (10, 10, N'Bộ nội thất phòng khách sang trọng', 500000),
    (1, 1, N'Xi măng xây dựng chất lượng trung bình', 110000),
    (2, 2, N'Thép ống dẹp chất lượng cao', 800000),
    (3, 3, N'Cát xây dựng đạt tiêu chuẩn', 130000),
    (4, 4, N'Gạch xây dựng vuông chất lượng đảm bảo', 4000),
    (5, 5, N'Sắt tròn chất lượng ổn định', 85000),
    (6, 6, N'Sàn gỗ công nghiệp bền chắc', 380000),
    (7, 7, N'Gạch lát tường đẹp mắt', 220000),
    (8, 8, N'Vật liệu trần nhựa chất lượng cao', 320000),
    (9, 9, N'Bộ ngoại thất phong cách hiện đại', 690000),
    (10, 10, N'Bộ nội thất phòng khách hiện đại', 520000),
    (1, 1, N'Xi măng xây dựng chất lượng tốt', 160000),
    (2, 2, N'Sắt thép xây dựng chất lượng cao', 270000),
    (3, 3, N'Cát xây dựng cô đặc', 150000),
    (4, 4, N'Gạch xây dựng tròn chất lượng tốt', 5500),
    (5, 5, N'Sắt vuông chất lượng ổn định', 55000),
    (6, 6, N'Thảm trải sàn nhựa cao cấp', 250000),
    (7, 7, N'Gạch lát tường bóng kính', 130000),
    (8, 8, N'Vật liệu trần gỗ', 440000),
    (9, 9, N'Bộ ngoại thất phong cách cổ kính', 1190000),
    (10, 10, N'Bộ nội thất phòng khách cổ kính', 830000);
GO


INSERT INTO KHOHANG (DIACHI)
VALUES
    (N'Kho Hồ Chí Minh 1'),
    (N'Kho Hà Nội 1'),
    (N'Kho Đà Nẵng'),
    (N'Kho Nghệ An'),
    (N'Kho Cần Thơ'),
    (N'Kho Huế'),
    (N'Kho Bình Dương'),
    (N'Kho Hồ Chí Minh 2'),
    (N'Kho Hà Nội 2'),
    (N'Kho Thái Nguyên');
GO



INSERT INTO KHOHANGCHITIET(MAKHO,MASP,SOLUONG)
VALUES
	(1,1,5000),
	(1,11,6000),
	(1,21,4500),
	(2,2,300),
	(2,12,440),
	(2,22,340),
	(3,3,1000),
	(3,13,2400),
	(3,23,2000),
	(4,4,25000),
	(4,14,50000),
	(4,24,22000),
	(5,5,1200),
	(5,15,1000),
	(5,25,800),
	(6,6,250),
	(6,16,400),
	(6,26,300),
	(7,7,2200),
	(7,17,2600),
	(7,27,3100),
	(8,8,950),
	(8,18,1350),
	(8,28,1400),
	(9,9,25),
	(9,19,10),
	(9,29,5),
	(10,10,40),
	(10,20,30),
	(10,30,20);
GO

INSERT INTO HOADON (MAKHACH,MAKHO, NGAYLAPHOADON, LOAIHOADON, TRANGTHAI)
VALUES
    (1,1, '2020-01-01', N'Nhập', 'Pending'),
    (2,3, '2020-02-02', N'Xuất', 'Delivering'),
    (3,5, '2020-03-03', N'Nhập', 'Delivered'),
    (4,7, '2020-04-04', N'Xuất', 'Cancelled'),
    (5,9, '2020-05-05', N'Nhập', 'Returned'),
    (6,2, '2020-06-06', N'Xuất', 'Pending'),
    (7,4, '2020-07-07', N'Nhập', 'Delivering'),
    (8,6, '2020-08-08', N'Xuất', 'Delivered'),
    (9,8, '2020-09-09', N'Nhập', 'Cancelled'),
    (10,10, '2020-10-10', N'Xuất', 'Returned'),
    (1,10, '2021-01-01', N'Nhập', 'Pending'),
    (2,9, '2021-02-02', N'Xuất', 'Delivering'),
    (3,8, '2021-03-03', N'Nhập', 'Delivered'),
    (4,7, '2021-04-04', N'Xuất', 'Cancelled'),
    (5,6, '2021-05-05', N'Nhập', 'Returned'),
    (6,5, '2021-06-06', N'Xuất', 'Pending'),
    (7,4, '2021-07-07', N'Nhập', 'Delivering'),
    (8,3, '2021-08-08', N'Xuất', 'Delivered'),
    (9,2, '2021-09-09', N'Nhập', 'Cancelled'),
    (10,1, '2021-10-10', N'Xuất', 'Returned'),
    (1,1,'2022-01-01', N'Nhập', 'Pending'),
    (2,2, '2022-02-02', N'Xuất', 'Delivering'),
    (3,3, '2022-03-03', N'Nhập', 'Delivered'),
    (4,4, '2022-04-04', N'Xuất', 'Cancelled'),
    (5,5, '2022-05-05', N'Nhập', 'Returned'),
    (6,6, '2022-06-06', N'Xuất', 'Pending'),
    (7,7, '2022-07-07', N'Nhập', 'Delivering'),
    (8,8, '2022-08-08', N'Xuất', 'Delivered'),
    (9,9, '2022-09-09', N'Nhập', 'Cancelled'),
    (10,10, '2022-10-10', N'Xuất', 'Returned'),
    (1,2, '2023-01-01', N'Nhập', 'Pending'),
    (2,4, '2023-02-02', N'Xuất', 'Delivering'),
    (3,6, '2023-03-03', N'Nhập', 'Delivered'),
    (4,8, '2023-04-04', N'Xuất', 'Cancelled'),
    (5,10, '2023-05-05', N'Nhập', 'Returned'),
    (6,1, '2023-06-06', N'Xuất', 'Pending'),
    (7,3, '2023-07-07', N'Nhập', 'Delivering'),
    (8,5, '2023-08-08', N'Xuất', 'Delivered'),
    (9,6, '2023-09-09', N'Nhập', 'Cancelled'),
    (10,9, '2023-10-10', N'Xuất', 'Returned'),
    (1,5, '2023-01-11', N'Nhập', 'Pending'),
    (2,4, '2023-02-12', N'Xuất', 'Delivering'),
    (3,3, '2023-03-13', N'Nhập', 'Delivered'),
    (4,2, '2023-04-14', N'Xuất', 'Cancelled'),
    (5,1, '2023-05-15', N'Nhập', 'Returned'),
    (6,10, '2023-06-16', N'Xuất', 'Pending'),
    (7,9, '2023-07-17', N'Nhập', 'Delivering'),
    (8,8, '2023-08-18', N'Xuất', 'Delivered'),
    (9,7, '2023-09-19', N'Nhập', 'Cancelled'),
    (10,6, '2023-10-20', N'Xuất', 'Returned');
GO

INSERT INTO HOADONCHITIET(MASP, MAHD, SOLUONG)
VALUES
	(1, 1, 10),
    (3, 2, 5),
    (5, 3, 8),
    (6, 4, 3),
    (6, 5, 12),
    (7, 6, 6),
    (8, 7, 20),
    (12, 8, 10),
    (3, 9, 4),
    (22, 10, 2),
    (30, 11, 6),
    (13, 12, 3),
    (18, 13, 15),
    (22, 14, 7),
    (4, 15, 10),
    (9, 16, 5),
    (10, 17, 2),
    (29, 18, 1),
    (27, 19, 3),
    (15, 20, 2),
    (1, 21, 5),
    (23, 22, 2),
    (27, 23, 8),
    (24, 24, 40),
    (18, 25, 10),
    (7, 26, 5),
    (4, 27, 25),
    (11, 28, 12),
    (13, 29, 3),
    (17, 30, 2),
    (19, 31, 6),
    (9, 32, 3),
    (20, 33, 5),
    (10, 34, 7),
    (30, 35, 4),
    (26, 36, 5),
    (24, 37, 100),
    (14, 38, 120),
    (2, 39, 3),
    (8, 40, 2),
    (5, 41, 5),
    (4, 42, 150),
    (1, 43, 8),
    (11, 44, 4),
    (21, 45, 10),
    (25, 46, 5),
    (15, 47, 25),
    (16, 48, 12),
    (13, 49, 3),
    (18, 50, 2);
GO

-- TRIGGER


--DEL Hóa Đơn
CREATE OR ALTER TRIGGER DeleteHoaDon
ON HOADON
AFTER DELETE
AS
BEGIN
    DELETE FROM HOADON
    WHERE MAHD IN (SELECT MAHD FROM deleted);
END;
GO


--DEL Sản Phẩm
CREATE OR ALTER TRIGGER DeleteSanPham
ON SANPHAM
AFTER DELETE
AS
BEGIN
    DELETE FROM SANPHAM
    WHERE MASP IN (SELECT MASP FROM deleted);
END;
GO


