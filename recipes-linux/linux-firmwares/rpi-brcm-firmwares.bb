SUMMARY = "Firmware files for RPi broadcom"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rpi-brcm-firmwares.zip"

SRC_URI[md5sum] = "7bf210101ad113ee3b5ab65f30983365"
SRC_URI[sha256sum] = "198648797844292be1f5c9812120b9ad391eea14c1096fd01b41ac66562ecfba"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware/brcm"

do_install() {
    install -d ${D}${base_libdir}/firmware/brcm
    install -m 0644 *.bin ${D}${base_libdir}/firmware/brcm/
    install -m 0644 *.hcd ${D}${base_libdir}/firmware/brcm/
    install -m 0644 *.txt ${D}${base_libdir}/firmware/brcm/
}
