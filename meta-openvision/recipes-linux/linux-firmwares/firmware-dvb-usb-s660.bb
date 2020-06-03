require linux-firmware.inc

DESCRIPTION = "Firmware for DVB USB TeVii S660 adapter"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-s660.fw ${D}${nonarch_base_libdir}/firmware
}
