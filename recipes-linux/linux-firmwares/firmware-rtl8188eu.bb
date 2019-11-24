require linux-firmware.inc

DESCRIPTION = "Firmware for RTL8188EU"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/rtlwifi
	install -m 0644 rtlwifi/rtl8188eufw.bin ${D}/${nonarch_base_libdir}/firmware/rtlwifi/
}
