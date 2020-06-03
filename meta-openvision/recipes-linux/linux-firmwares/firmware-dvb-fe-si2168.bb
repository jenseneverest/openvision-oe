LICENSE = "CLOSED"
require conf/license/license-close.inc

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/firmware-si2158.zip"

SRC_URI[md5sum] = "9ac3cd2d28752242caa7ead0bf5e6eb0"
SRC_URI[sha256sum] = "dcb99aa1b66ec16997f1c2316e2abd83318772b27b09089aa4aef9191490c9c5"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

inherit allarch

SUMMARY = "Firmware for si2158"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0644 dvb-demod-si2168-02.fw ${D}${nonarch_base_libdir}/firmware
    install -m 0644 dvb-demod-si2168-a20-01.fw ${D}${nonarch_base_libdir}/firmware
    install -m 0644 dvb-demod-si2168-a30-01.fw ${D}${nonarch_base_libdir}/firmware
    install -m 0644 dvb-demod-si2168-b40-01.fw ${D}${nonarch_base_libdir}/firmware
    install -m 0644 dvb-demod-si2168-d60-01.fw ${D}${nonarch_base_libdir}/firmware
    install -m 0644 dvb-tuner-si2141-a10-01.fw ${D}${nonarch_base_libdir}/firmware
    install -m 0644 dvb-tuner-si2158-a20-01.fw ${D}${nonarch_base_libdir}/firmware
}
