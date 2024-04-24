

INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV001', N'NV001')


INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV001', N'NV001', N'Ph?m V? Ho�i An', N'Ph?c v?', N'N?', CAST(N'2000-04-20' AS Date), N'60 Th?ng Nh?t, p10, Q.G� V?p', N'0966105479', '079001013302', 5000000, N'1', N'?ang l�m vi?c')

INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'LP001', N'Ph�ng th??ng')

INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P001', N'LP001', N'Tr?ng', 100000,12,N'C? ?i?n')

INSERT [dbo].[LoaiMatHang] ([maLoaiMH], [tenLoaiMH]) VALUES (N'LMH001', N'?? u?ng')

INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH002', N'LMH001', N'Bia Heniken Silver', 600, 45000)

INSERT [dbo].[LoaiKH] ([maLoaiKH], [tenLoaiKH]) VALUES (N'LKH001', N'Kh�ch h�ng th??ng')

INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH001', N'LKH001', N'?o�n Ph?m B�ch H?p', N'0708985897', N'056546236412', N'1358 Quang Trung, P.14, Q.G� V?p', CAST(N'2001-03-01' AS Date), N'N?', 0, CAST(N'2021-08-03' AS Date))

INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD001', N'P001', N'KH001', N'NV001', CAST(N'2020-10-11' AS Date), CAST(N'10:30:00' AS Time), CAST(N'13:30:00' AS Time), N'Kh�ng', N'?� thanh to�n', 0)

INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKhachHang], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP001', N'P001', N'KH001', N'NV001', CAST(N'2020-10-11' AS Date), CAST(N'10:30:00' AS Time), CAST(N'2020-10-11' AS Date), N'?� tr? ph�ng')

INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD001', N'MH002', 10)

INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP001', N'MH002', 10)