require linux-firmware.inc

DESCRIPTION = "Firmware for dvb-fe-cx24117"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 dvb-fe-cx24117.fw ${D}${nonarch_base_libdir}/firmware
}