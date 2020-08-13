require linux-firmware.inc

DESCRIPTION = "Firmware for RTL8822BE"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/rtlwifi
	install -d ${D}${nonarch_base_libdir}/firmware/rtl_bt
	install -m 0644 rtlwifi/rtl8822befw.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi/
	install -m 0644 rtl_bt/rtl8822b_fw.bin ${D}${nonarch_base_libdir}/firmware/rtl_bt/
	install -m 0644 rtl_bt/rtl8822b_config.bin ${D}${nonarch_base_libdir}/firmware/rtl_bt/
}
