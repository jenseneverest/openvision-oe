require linux-firmware.inc

DESCRIPTION = "Firmware for dvb-usb-digivox-02"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-usb-digivox-02.fw ${D}${nonarch_base_libdir}/firmware
}
