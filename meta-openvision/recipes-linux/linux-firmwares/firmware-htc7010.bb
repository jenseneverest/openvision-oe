require linux-firmware.inc

DESCRIPTION = "Firmware for HTC7010"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 htc_7010.fw ${D}/${nonarch_base_libdir}/firmware/
}
