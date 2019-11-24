require linux-firmware.inc

DESCRIPTION = "Firmware for TBS 5980"

FW = "dvb-usb-tbsqbox-id5980.fw"

do_install() {
        install -d ${D}${nonarch_base_libdir}/firmware
        install -m 0644 ${FW} ${D}${nonarch_base_libdir}/firmware
}
