require linux-firmware.inc

DESCRIPTION = "Firmware for RTL8712U"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/rtlwifi
	install -m 0644 rtlwifi/rtl8712u.bin ${D}/${nonarch_base_libdir}/firmware/rtlwifi/
}
