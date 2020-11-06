SUMMARY = "Multi boot loader for enigma2"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit gitpkgv ${PYTHONNAMEONLY}native gettext autotools-brokensep rm_python_pyc compile_python_pyo no_python_src

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://github.com/OpenVisionE2/openmultibootmanager.git;protocol=git"

S = "${WORKDIR}/git"

DEPENDS = "${PYTHONNAMEONLY} lzo"

BLOCK2MTD_CHECK = "${@bb.utils.contains("MACHINE_FEATURES", "dreambox", "", "kernel-module-block2mtd", d)}"

RDEPENDS_${PN} = "\
    ${@bb.utils.contains("IMAGE_FSTYPES", "jffs2", "${BLOCK2MTD_CHECK} kernel-module-nandsim" , "", d)} \
    ${@bb.utils.contains_any("IMAGE_FSTYPES", "ubi tar", "kernel-module-nandsim" , "", d)} \
    lzo \
    openmultiboot \
    "

EXTRA_OECONF = "\
    --with-po \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-arch=${TARGET_ARCH} \
    "

# skip this!
install_egg_info() {
}

do_configure_prepend() {
    touch ${S}/NEWS
    touch ${S}/README
    touch ${S}/AUTHORS
    touch ${S}/ChangeLog
}

pkg_preinst_${PN}() {
#!/bin/sh
if mountpoint -q ${libdir}/enigma2/python/Plugins/Extensions/OpenMultiboot; then
    echo "OpenMultiboot will only install on main image."
    echo "Child image is running - canceling installation!"
    sleep 3
    exit 1
else
    echo "Main image is running - proceeding installation..."
    exit 0
fi
}
