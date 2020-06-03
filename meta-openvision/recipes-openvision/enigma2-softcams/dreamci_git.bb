SUMMARY = "dreamci module"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = "openssl"
RDEPENDS_${PN} = "enigma2-plugin-extensions-socketmmi"

S = "${WORKDIR}/git"

SRC_URI = "git://github.com/OpenVisionE2/dreamci.git;protocol=http"

inherit gitpkgv

PV = "9.7+git${SRCPV}"
PKGV = "9.7+git${GITPKGV}"

FILES_${PN} = "${bindir}"

do_compile () {
        make -C ${S}/src dreamciplus
}

do_install() {
  find "${D}" -name '*.sh' -exec chmod a+x '{}' ';'
  install -d ${D}${bindir}
  install -m 0755 ${S}/src/dreamciplus ${D}${bindir}
  install -m 0755 ${S}/src/enigma2_pre_start_ciplus.sh ${D}${bindir}
}

pkg_postinst_${PN} () {
#!/bin/sh
  if [ -e ${bindir}/dreamciplus ]; then
     ${bindir}/dreamciplus $1
  fi
exit 0
}

pkg_prerm_${PN} () {
#!/bin/sh
  if [ -e ${bindir}/dreamciplus ]; then
     ${bindir}/dreamciplus $1
  fi
exit 0
}

do_package_qa() {
}

