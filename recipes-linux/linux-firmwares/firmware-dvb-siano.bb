require linux-firmware.inc

DESCRIPTION = "Firmware for Siano USB DVB"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware
	install -m 0644 sms1xxx-hcw-55xxx-dvbt-02.fw ${D}${nonarch_base_libdir}/firmware
	install -m 0644 sms1xxx-hcw-55xxx-isdbt-02.fw ${D}${nonarch_base_libdir}/firmware
	install -m 0644 sms1xxx-nova-a-dvbt-01.fw ${D}${nonarch_base_libdir}/firmware
	install -m 0644 sms1xxx-nova-b-dvbt-01.fw ${D}${nonarch_base_libdir}/firmware
}
