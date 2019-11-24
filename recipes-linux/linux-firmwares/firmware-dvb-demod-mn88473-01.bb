require linux-firmware.inc

DESCRIPTION = "Firmware for demod mn88473"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-demod-mn88473-01.fw ${D}${nonarch_base_libdir}/firmware
}
