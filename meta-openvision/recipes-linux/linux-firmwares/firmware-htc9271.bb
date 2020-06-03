require linux-firmware.inc

DESCRIPTION = "Firmware for HTC9271"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 htc_9271.fw ${D}/${nonarch_base_libdir}/firmware/
}
