require linux-firmware-local.inc

DESCRIPTION = "Firmware for demod mn88472"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-demod-mn88472-02.fw ${D}${nonarch_base_libdir}/firmware
}
