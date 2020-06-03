SUMMARY = "Firmware files for avl6882"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit allarch

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/dvb-demod-avl6882.zip"

SRC_URI[md5sum] = "bf7302eb36a0cae712710558b80cd047"
SRC_URI[sha256sum] = "9d16d1d3c76c2be4b2eeda497666c5ee632c245e4881c8a14eef054c0a750bca"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0644 ${S}/dvb-demod-avl6882.fw ${D}${nonarch_base_libdir}/firmware/dvb-demod-avl6882.fw
}
