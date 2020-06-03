require linux-firmware.inc

DESCRIPTION = "Firmware for dvb-usb-it9135"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-it9135.fw ${D}${nonarch_base_libdir}/firmware
}
