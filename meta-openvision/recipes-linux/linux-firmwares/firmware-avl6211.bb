SUMMARY = "Firmware files for avl6211"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit allarch

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/firmware-avl6211.zip"

SRC_URI[md5sum] = "45f55bfec9954ea26923ad442fb3336b"
SRC_URI[sha256sum] = "c47ba63cce9527c668efe45b86aa5d5aa84c475bc9debce07f18e362c578f382"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0644 dvb-fe-avl6211.fw ${D}${nonarch_base_libdir}/firmware/dvb-fe-avl6211.fw
}
