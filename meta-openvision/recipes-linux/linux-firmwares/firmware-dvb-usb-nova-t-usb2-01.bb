require linux-firmware.inc

DESCRIPTION = "Firmware for dvb-usb-nova-t-usb2-01.fw"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-nova-t-usb2-01.fw ${D}${nonarch_base_libdir}/firmware
}
