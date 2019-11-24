require linux-firmware.inc

DESCRIPTION = "Firmware for dvb-usb-dibusb-5.0.0.11"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-dibusb-5.0.0.11.fw ${D}${nonarch_base_libdir}/firmware
}
