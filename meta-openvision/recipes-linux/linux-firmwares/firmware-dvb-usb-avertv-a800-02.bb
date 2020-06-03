require linux-firmware.inc

DESCRIPTION = "Firmware for dvb-usb-az6027-03"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-az6027-03.fw ${D}${nonarch_base_libdir}/firmware
}
