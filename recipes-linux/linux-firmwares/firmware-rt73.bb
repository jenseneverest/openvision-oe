require linux-firmware.inc

DESCRIPTION = "Firmware for RT73"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 rt73.bin ${D}${nonarch_base_libdir}/firmware
}
