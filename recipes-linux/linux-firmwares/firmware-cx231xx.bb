require linux-firmware.inc

DESCRIPTION = "Firmware for cx231xx"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 v4l-cx231xx-avcore-01.fw ${D}${nonarch_base_libdir}/firmware
}
