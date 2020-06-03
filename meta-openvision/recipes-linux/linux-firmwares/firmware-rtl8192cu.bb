require linux-firmware.inc

DESCRIPTION = "Firmware for RTL8192CU"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/rtlwifi
	install -m 0644 rtlwifi/rtl8192cufw.bin ${D}/${nonarch_base_libdir}/firmware/rtlwifi/
}
