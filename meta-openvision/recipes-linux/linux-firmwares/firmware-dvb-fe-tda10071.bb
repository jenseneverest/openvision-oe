require linux-firmware.inc

DESCRIPTION = "Firmware for TDA10071 dvb frontend"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-fe-tda10071.fw ${D}${nonarch_base_libdir}/firmware
}
