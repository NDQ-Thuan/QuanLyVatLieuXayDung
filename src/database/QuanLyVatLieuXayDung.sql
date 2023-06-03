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
	TENKHOHANG NVARCHAR(50) NOT NULL,
    DIACHI NVARCHAR(200) NULL,
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
    (N'Công ty CP VLXD Đào Nguyên', N'9 Đường Số 6, Quận Tân Bình, TP. HCM', '0990123456'),
	(N'Công ty VLXD Vĩnh Cường',N'196 Nguyễn Thị Định, P. An Phú, Q.2, TPHCM','0971356662'),
	(N'Công ty TNHH VLXD Quế Đông',N'783 Hà Huy Giáp, P. Thạnh Xuân, Q.12, TPHCM','0997274652'),
	(N'Công ty Cổ Phần Vicostone',N'Khu công nghệ cao Hòa Lạc, Thạch Hòa, Thạch Thất, Hà Nội','18006766'),
	(N'Tổng công ty Viglacera - CTCP',N'Tòa nhà Viglacera, Số 1 Đại lộ Thăng Long, Hà Nội','35536660'),
	(N'Công ty Cổ Phần Eurowindow',N'Tòa nhà văn phòng Eurowindow Office Building, Số 02 Tôn Thất Tùng, Đống Đa, Hà Nội','37474777'),
	(N'Công ty TNHH Siam City Cement',N'Tầng 12-14, Tòa Nhà E-Town Central 11 Đường Đoàn Văn Bơ, Phường 12, Quận 4, TP. HCM','02873017018'),
	(N'Công ty Cổ Phần Gỗ An Cường',N'Đường ĐT 747B, Khu phố Phước Hải, P. Thái Hòa, Thị xã Tân Uyên, Tỉnh Bình Dương','19006944'),
	(N'Công ty CP Vicem VLXD Đà Nẵng',N'Tầng 6 DITP Tower, Nguyễn Tất Thành, Hoà Hiệp Nam, Liên Chiểu, Đà Nẵng','02363707814'),
	(N'Công Ty Cp Vlxd Thừa Thiên Huế',N'139 Bà Triệu, Xuân Phú, Thành phố Huế, Thừa Thiên Huế','02343823080'),
	(N'Công Ty Cổ Phần Xi Măng Tây Đô',N'65A Đường Tầm Vu, Phường Hưng Lợi, Quận Ninh Kiều, Thành Phố Cần Thơ','07103839045');

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


INSERT INTO KHOHANG (TENKHOHANG, DIACHI,SDTQUANLY)
VALUES
    (N'Kho Hồ Chí Minh 1', N'Số 7 Công Trường Lam Sơn, Quận 1, Thành phố Hồ Chí Minh', '1900636677'),
	(N'Kho Hồ Chí Minh 2', N'144 Xuân Thủy, Quận Cầu Giấy, Thành phố Hồ Chí Minh', '19008095'),
    (N'Kho Hà Nội 1', N'Số 58 Quốc Tử Giám, Văn Miếu, Đống Đa, Hà Nội', '1900545481'),
	(N'Kho Hà Nội 2', N'Số 18 Phan Bội Châu, Hoàn Kiếm, Hà Nội', '19001088'),
    (N'Kho Đà Nẵng', N'Số 100 Võ Nguyên Giáp, Phường Khương Đông, Quận Ngũ Hành Sơn, Đà Nẵng', '1900886877'),
    (N'Kho Nghệ An', N'Số 22 Trường Thi, TP. Vinh, Nghệ An', '19001031'),
    (N'Kho Cần Thơ', N' 46 Hai Bà Trưng, phường An Bình, quận Ninh Kiều, Cần Thơ', '1900232345'),
    (N'Kho Huế', N'Số 2 Thái Phiên, Phường Hiệp Hòa, Thành phố Huế, Thừa Thiên Huế', '1900545411'),
    (N'Kho Bình Dương', N'Lô A1, Đại lộ Bình Dương, KCN Việt Nam - Singapore, Thị xã Thuận An, Bình Dương', '19001221'),
    (N'Kho Thái Nguyên', N'Số 20 Trần Phú, phường Tân Lập, thành phố Thái Nguyên, tỉnh Thái Nguyên', '19002828');
GO



INSERT INTO KHOHANGCHITIET(MAKHO,MASP,SOLUONG)
VALUES
	(10, 25, 4523),
	(8, 3, 6714),
	(4, 28, 2181),
	(7, 12, 3467),
	(3, 15, 9321),
	(6, 8, 9876),
	(5, 9, 7825),
	(9, 19, 3498),
	(6, 23, 2567),
	(7, 2, 5324),
	(1, 27, 5690),
	(10, 26, 3615),
	(7, 29, 7622),
	(9, 13, 9867),
	(5, 4, 4321),
	(2, 13, 6276),
	(9, 8, 8921),
	(3, 11, 5265),
	(4, 7, 4567),
	(8, 17, 6875),
	(4, 19, 8901),
	(10, 20, 6425),
	(1, 5, 5700),
	(5, 16, 8324),
	(1, 23, 3465),
	(7, 1, 4532),
	(9, 30, 8125),
	(2, 1, 6278),
	(1, 30, 1201),
	(6, 19, 5467),
	(10, 3, 2495),
	(3, 25, 4326),
	(2, 4, 2567),
	(5, 15, 7491),
	(8, 6, 4367),
	(1, 18, 5605),
	(10, 13, 3572),
	(7, 26, 8025),
	(9, 9, 1250),
	(6, 22, 8643),
	(2, 17, 2478),
	(5, 12, 7263),
	(4, 24, 3456),
	(1, 20, 5800),
	(3, 2, 8265),
	(8, 11, 6876),
	(10, 16, 4632),
	(6, 28, 6843),
	(9, 5, 7211),
	(7, 18, 2398),
	(4, 20, 8934),
	(3, 7, 6265),
	(5, 24, 7934),
	(1, 3, 5100),
	(10, 7, 1525),
	(2, 6, 3678),
	(8, 15, 7875),
	(6, 9, 6643),
	(9, 29, 9625),
	(7, 13, 7891),
	(1, 4, 5200);
GO

INSERT INTO HOADON (MAKHACH,MAKHO, NGAYLAPHOADON, LOAIHOADON, TRANGTHAI)
VALUES
	(1,9, '2023-01-01', N'Nhập', 'Pending'),
    (2,10, '2023-01-11', N'Xuất', 'Pending'),
    (3,1, '2023-01-21', N'Nhập', 'Delivered'),
    (4,2, '2023-01-02', N'Xuất', 'Cancelled'),
    (5,3, '2023-01-12', N'Nhập', 'Returned'),
    (6,4, '2023-01-22', N'Xuất', 'Pending'),
    (7,5, '2023-01-03', N'Nhập', 'Delivering'),
    (8,6, '2023-01-13', N'Xuất', 'Delivered'),
    (9,7, '2023-01-23', N'Nhập', 'Cancelled'),
    (10,8, '2023-1-30', N'Xuất', 'Returned'),

    (11,10, '2023-02-04', N'Nhập', 'Pending'),
    (12,9, '2023-02-14', N'Xuất', 'Delivering'),
    (13,8, '2023-02-24', N'Nhập', 'Delivered'),
    (14,7, '2023-02-05', N'Xuất', 'Cancelled'),
    (15,6, '2023-02-15', N'Nhập', 'Returned'),
    (16,5, '2023-02-25', N'Xuất', 'Pending'),
    (17,4, '2023-02-06', N'Nhập', 'Delivering'),
    (18,3, '2023-02-16', N'Xuất', 'Delivered'),
    (19,2, '2023-02-26', N'Nhập', 'Cancelled'),
    (20,1, '2023-02-28', N'Xuất', 'Returned'),

    (20,3,'2023-03-07', N'Nhập', 'Pending'),
    (19,5, '2023-03-17', N'Xuất', 'Delivering'),
    (18,7, '2023-03-27', N'Nhập', 'Delivered'),
    (17,9, '2023-03-08', N'Xuất', 'Cancelled'),
    (16,1, '2023-03-18', N'Nhập', 'Returned'),
    (15,2, '2023-03-28', N'Xuất', 'Returned'),
    (14,4, '2023-03-09', N'Nhập', 'Delivering'),
    (13,6, '2023-03-19', N'Xuất', 'Delivered'),
    (12,8, '2023-03-29', N'Nhập', 'Cancelled'),
    (11,10, '2023-03-30', N'Xuất', 'Pending'),

    (10,5, '2023-04-03', N'Nhập', 'Pending'),
    (9,7, '2023-04-03', N'Xuất', 'Delivering'),
    (8,9, '2023-04-12', N'Nhập', 'Delivered'),
    (7,10, '2023-04-15', N'Xuất', 'Pending'),
    (6,1, '2023-04-17', N'Nhập', 'Returned'),
    (5,2, '2023-04-19', N'Xuất', 'Cancelled'),
    (4,3, '2023-04-25', N'Nhập', 'Delivering'),
    (3,8, '2023-04-27', N'Xuất', 'Delivered'),
    (2,6, '2023-04-29', N'Nhập', 'Cancelled'),
    (1,4, '2023-04-30', N'Xuất', 'Returned'),

    (2,1, '2023-05-01', N'Nhập', 'Pending'),
    (4,3, '2023-05-03', N'Xuất', 'Delivering'),
    (6,4, '2023-05-07', N'Xuất', 'Delivered'),
    (8,5, '2023-05-10', N'Xuất', 'Delivered'),
    (10,2, '2023-05-14', N'Nhập', 'Returned'),
    (12,6, '2023-05-18', N'Xuất', 'Delivering'),
    (14,10, '2023-05-19', N'Nhập', 'Delivering'),
    (16,8, '2023-05-20', N'Xuất', 'Pending'),
    (18,7, '2023-05-22', N'Nhập', 'Cancelled'),
    (20,8, '2023-05-25', N'Xuất', 'Delivered'),

    (1,9, '2023-06-02', N'Nhập', 'Pending'),
    (3,8, '2023-06-03', N'Xuất', 'Pending'),
    (5,7, '2023-06-04', N'Nhập', 'Delivered'),
    (7,6, '2023-06-05', N'Xuất', 'Pending'),
    (9,5, '2023-06-05', N'Nhập', 'Returned'),
    (11,4, '2023-06-07', N'Xuất', 'Pending'),
    (13,3, '2023-06-07', N'Nhập', 'Delivering'),
    (15,2, '2023-06-09', N'Xuất', 'Delivered'),
    (17,10, '2023-06-10', N'Nhập', 'Cancelled'),
    (19,1, '2023-06-15', N'Xuất', 'Pending');


INSERT INTO HOADONCHITIET(MASP, MAHD, SOLUONG)
VALUES
	(24, 1, 96),
	(27, 2, 214),
	(11, 3, 105),
	(14, 4, 22),
	(2, 5, 71),
	(26, 6, 132),
	(5, 7, 67),
	(13, 8, 98),
	(8, 9, 191),
	(1, 10, 295),
	(18, 11, 160),
	(29, 12, 225),
	(19, 13, 8),
	(20, 14, 288),
	(6, 15, 60),
	(9, 16, 155),
	(12, 17, 263),
	(10, 18, 80),
	(17, 19, 248),
	(23, 20, 136),
	(28, 21, 252),
	(4, 22, 206),
	(16, 23, 218),
	(22, 24, 82),
	(7, 25, 51),
	(21, 26, 47),
	(15, 27, 180),
	(25, 28, 194),
	(3, 29, 276),
	(30, 30, 273),
	(3, 31, 196),
	(25, 32, 231),
	(24, 33, 270),
	(11, 34, 220),
	(18, 35, 122),
	(10, 36, 53),
	(14, 37, 23),
	(28, 38, 246),
	(9, 39, 38),
	(27, 40, 92),
	(5, 41, 207),
	(23, 42, 233),
	(1, 43, 162),
	(21, 44, 209),
	(16, 45, 189),
	(26, 46, 268),
	(20, 47, 166),
	(8, 48, 268),
	(29, 49, 165),
	(15, 50, 190),
	(7, 51, 278),
	(22, 52, 136),
	(4, 53, 60),
	(13, 54, 13),
	(12, 55, 284),
	(19, 56, 156),
	(2, 57, 220),
	(30, 58, 98),
	(6, 59, 175),
	(17, 60, 39)
GO


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


SELECT * FROM KHOHANG