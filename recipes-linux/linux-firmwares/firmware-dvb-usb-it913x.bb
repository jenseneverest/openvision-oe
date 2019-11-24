require linux-firmware.inc

DESCRIPTION = "Firmware for dvb-usb-it913x"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-it9135-01.fw ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-it9135-02.fw ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-it9137-01.fw ${D}${nonarch_base_libdir}/firmware
}
