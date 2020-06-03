require linux-firmware.inc

DESCRIPTION = "Firmware for xc5000"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-fe-xc5000-1.6.114.fw ${D}${nonarch_base_libdir}/firmware
}
