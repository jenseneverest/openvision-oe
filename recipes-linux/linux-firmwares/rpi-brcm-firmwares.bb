SUMMARY = "Firmware files for RPi broadcom"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rpi-brcm-firmwares.zip"

SRC_URI[md5sum] = "1925d9ac839abb583c613b73d9ea35d2"
SRC_URI[sha256sum] = "b3451bdfbfb4be856ae659260006d4072c146fcacb88e665b1e45c6f1bbf6dde"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware/brcm"

do_install() {
    install -d ${D}${base_libdir}/firmware/brcm
    install -m 0644 *.bin ${D}${base_libdir}/firmware/brcm/
    install -m 0644 *.hcd ${D}${base_libdir}/firmware/brcm/
    install -m 0644 *.txt ${D}${base_libdir}/firmware/brcm/
}
