require linux-firmware.inc

DESCRIPTION = "Firmware for dvb-usb-wt220u-zl0353-01"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-wt220u-zl0353-01.fw ${D}${nonarch_base_libdir}/firmware
}
