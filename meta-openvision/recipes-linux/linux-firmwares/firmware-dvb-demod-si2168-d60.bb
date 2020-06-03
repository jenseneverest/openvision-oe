require linux-firmware.inc

DESCRIPTION = "Firmware for demod si2168 d60-01"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-demod-si2168-d60-01.fw ${D}${nonarch_base_libdir}/firmware
}
