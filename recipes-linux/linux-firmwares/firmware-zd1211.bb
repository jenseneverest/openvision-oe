require linux-firmware.inc

DESCRIPTION = "Firmware for ZD1211"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/zd1211
	install -m 0644 zd1211/* ${D}/${nonarch_base_libdir}/firmware/zd1211/
}
